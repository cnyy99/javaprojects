package network;

import java.net.*;  // 导入java.net网络包中的类
import java.io.*;   // 导入java.io输入输出流包中的类

public class JUDPReceiver {               // 主类：UDP协议接收方的演示程序
    public static void main(String[] args) {  // 主方法
        try {  // 处理可能出现的勾选异常
            System.out.println("Receive data at 8000......\n");
            // 接收前的准备工作：准备好存储缓冲区，将其包装成数据报包裹对象
            byte buf[] = new byte[128];  // 创建一个数据缓冲区（最多接收128个字节）
            DatagramPacket pack = new DatagramPacket(buf, buf.length);
            // 创建数据报套接字对象，监听某个UDP端口，等待接收数据报包裹
            DatagramSocket ds = new DatagramSocket(8000);  // 监听UDP 8000端口
            ds.receive(pack);                             // 接收数据报包裹
            // 分析接收到的数据报包裹，例如发送方的网址、端口和数据等
            InetAddress udpSender = pack.getAddress();  // 获取发送方的网络地址
            int port = pack.getPort();                  // 获取发送方的端口
            // 数据报里的数据是字节数组，可将其转成字符串
            String msg = new String(pack.getData(), 0, pack.getLength());  // 转字符串
            System.out.println("Receive data from " + udpSender + ":" + port);
            System.out.println("所接收到的数据：" + msg);
            ds.close();  // 关闭数据报套接字
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
