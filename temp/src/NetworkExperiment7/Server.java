package NetworkExperiment7;
/*
代码运行环境:
1.包NetworkExperiment7下
2.Java version
    java version "9.0.4"
    Java(TM) SE Runtime Environment (build 9.0.4+11)
    Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
3.开发工具及系统环境:
    IntelliJ IDEA 2018.1.7 (Ultimate Edition)
    Build #IU-181.5540.23, built on November 12, 2018
    Licensed to 陈 楠
    Subscription is active until October 13, 2019
    For educational use only.
    JRE: 1.8.0_152-release-1136-b43 amd64
    JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
    Windows 10 10.0
 */

import java.io.*;       //引入io
import java.net.Socket;//引入Socket
import java.net.ServerSocket;//引入ServerSocket

public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null; //初始化ServerSocket
        Socket s = null;        //初始化Socket
        Thread Sender = null;   //初始化Sender 线程
        Thread Receiver = null; //初始化Receiver 线程
        try {
            ss = new ServerSocket(7777);    //监听7777端口
            System.out.println("Server listen at port:7777...");
            s = ss.accept();    //接受连接请求
            String ip = s.getInetAddress().toString();//获取连接的ip地址
            ip = ip.substring(ip.indexOf("/") + 1) + ":" + s.getPort();//ip地址加入端口号
            System.out.println(ip + " has connected...");   //打印提示

            OutputStream outputStream = s.getOutputStream();    //得到socket的输出流
            InputStream inputStream = s.getInputStream();       //得到socket的输入流

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream); //将输出流封装为DataOutputStream
            DataInputStream dataInputStream = new DataInputStream(inputStream);     //将输入流封装为DataInputStream

            Sender sender = new Sender(dataOutputStream);       //发送数据
            Receiver receiver = new Receiver(dataInputStream, "Client"); //接收数据

            Sender = new Thread(sender);        //建立发送数据线程
            Receiver = new Thread(receiver);      //建立接收数据线程
            Sender.start();                     //发送数据线程启动
            Receiver.start();                    //接受数据线程启动
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                while (true) {
                    if (Receiver != null && !Sender.isAlive() && !Receiver.isAlive()) break;    //当两个线程没有运行完成时等待
                }
                s.close();      //线程运行结束,断开连接
                ss.close();     //线程运行结束,关闭ServerSocket
            } catch (IOException ignored) {
            }
        }
    }
}
