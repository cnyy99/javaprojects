package NetworkExperiment7;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIPClient implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;
    private String name;

    public NIPClient(int port, String name){
        this("localhost",port,name);
    }

    public NIPClient(String host,int port,String name){
        this.host = host;
        this.port = port;
        this.name = name;
    }

    public void init(){
        try {
            //打开一个选择器
            selector = Selector.open();
            //打开一个Socket监听通道
            socketChannel = SocketChannel.open();
            //设置该通道为非阻塞模式
            socketChannel.configureBlocking(false);
            //在非阻塞模式下，该方法在建立连接之前就会返回结果了，后续为了确认连接是否建立成功，可以调用finishConnect()
            socketChannel.connect(new InetSocketAddress(host,port));
            //订阅连接事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            stop = false;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        init();
        int i = 0;
        while (!stop){
            try {
                //无论是否有读写事件发生，selector每隔1s被唤醒一次
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    //判断是否连接到服务器
                    if(selectionKey.isConnectable()){
                        //判断连接是否建立成功
                        if(socketChannel.finishConnect()){
                            sendMsg(name+" Connect Success!");
                            socketChannel.register(selector,SelectionKey.OP_WRITE);
                        }
                    }
                    if(selectionKey.isWritable()){
                        sendMsg(name+" is saying \"Hello World\"!"+i++);
                        Thread.sleep(1000);
                    }
                    iterator.remove();
                }
                selectionKeys.clear();
            }catch (ConnectException e){
                System.out.println("连接失败!");
                return;
            }catch (IOException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String expression) throws IOException{
        byte[] bytes = expression.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        //翻转缓冲区，执行的操作：
        //1.将limit的位置设为position之后的一个位置
        //2.将position的位置重置为0
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        //清空缓冲区
        byteBuffer.clear();
    }
}
