/*
代码运行环境:
1.Java version
    java version "9.0.4"
    Java(TM) SE Runtime Environment (build 9.0.4+11)
    Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)

2.开发工具及系统环境:
    IntelliJ IDEA 2018.1.7 (Ultimate Edition)
    Build #IU-181.5540.23, built on November 12, 2018
    Licensed to 陈 楠
    Subscription is active until October 13, 2019
    For educational use only.
    JRE: 1.8.0_152-release-1136-b43 amd64
    JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
    Windows 10 10.0

 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sender implements Runnable {   //实现Runnable接口
    private DataOutputStream dataOutputStream;  //输出流

    public Sender(DataOutputStream dataOutputStream) {  //构造函数
        super();
        this.dataOutputStream = dataOutputStream;   //赋值输出流
    }

    @Override       //重写run方法
    public void run() {
        while (true) {  //无限循环
            try {
                String message; //定义 message
                BufferedReader bf = new BufferedReader( //使用BufferedReader封装标准输入
                        new InputStreamReader(System.in));
                message = bf.readLine();//读取一行
                dataOutputStream.writeUTF(message); //写入输出流,发送给对方
                if (message.equals("bye"))          //如果发送的是"bye",结束循环
                {
                    break;
                }
            } catch (IOException e) {

                break;
            }

        }
    }
}
