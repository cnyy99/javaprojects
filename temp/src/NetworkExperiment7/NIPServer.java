package NetworkExperiment7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIPServer implements Runnable {
    private int port;
    private volatile boolean stop;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public NIPServer(int port){
        this.port = port;
    }

    public void init(){
        try {
            //打开一个选择器
            selector = Selector.open();
            //打开一个Server-Socket监听通道
            serverSocketChannel = ServerSocketChannel.open();
            //设置该通道为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            //将通道注册在选择器上面，并将准备连接状态作为通道订阅时间
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            stop = false;
            System.out.println("服务器已经启动，端口号：" + port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        init();
        while (!stop){
            try {
                //无论是否有读写事件发生，selector每隔1s被唤醒一次
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    //判断是否准备好接收新进入的连接
                    if(selectionKey.isAcceptable()){
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                        //通过ServerSocketChannel的accept()创建SocketChannel实例
                        //完成该操作意味着完成TCP三次握手，TCP物理链路正式建立
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        //设置为非阻塞
                        socketChannel.configureBlocking(false);
                        //在选择器注册，并订阅读事件
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }
                    if(selectionKey.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        //创建byteBuffer，并开辟一个1M的缓冲区
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        //读取请求码流，返回读取到的字节数
                        int readBytes = socketChannel.read(byteBuffer);
                        //判断客户端是否断开
                        if(readBytes < 0){
                            selectionKey.cancel();
                            socketChannel.close();
                            return;
                        }
                        //读取到字节，对字节进行编解码
                        if(readBytes>0){
                            //将缓冲区从写模式切换到读模式
                            byteBuffer.flip();
                            //根据缓冲区可读字节数创建字节数组
                            byte[] bytes = new byte[byteBuffer.remaining()];
                            //向缓冲区读数据到字节数组
                            byteBuffer.get(bytes);
                            String expression = new String(bytes,"UTF-8");
                            System.out.println("服务器收到消息："+expression);
                        }
                    }
                    iterator.remove();
                }
                selectionKeys.clear();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        //selector关闭后会自动释放里面管理的资源
        if(selector != null){
            try {
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
