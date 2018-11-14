package network;

import java.net.*;  // 导入java.net网络包中的类
import java.io.*;   // 导入java.io输入输出流包中的类

public class JUDPSender {                // 主类：UDP协议发送方的演示程序
    public static void main(String[] args) {  // 主方法
        try {  // 处理可能出现的勾选异常
            System.out.print("Send data to localhost:8000...... ");
            // 发送前的准备工作：准备好接收方网址、端口和需发送的数据
            InetAddress udpReceiver = InetAddress.getByName("localhost");  // 发给本机
            int port = 8000;             // 接收方端口（本例为UDP 8000）
            String msg = "Hello, World!";  // 将被发送的信息（本例为“Hello, World!”）
            byte buf[] = msg.getBytes();   // 将字符串信息转成字节数组
            // 创建数据报包裹对象，其中包含需被发送的数据和接收方的网址和端口
            DatagramPacket pack = new DatagramPacket(buf, buf.length, udpReceiver, port);
            // 创建数据报套接字对象，然后发送准备好的数据报包裹对象pack
            DatagramSocket ds = new DatagramSocket();  // 创建一个数据报套接字对象
            ds.send(pack);  // 发送数据报包裹
            ds.close();     // 关闭数据报套接字
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
