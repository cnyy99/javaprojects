package NetworkExperiment7;/*
代码运行环境:
1.Java version
    java version "9.0.4"
    Java(TM) SE Runtime Environment (build 9.0.4+11)
    Java HotSpot(TM) 64-Bit NetworkExperiment7.Server VM (build 9.0.4+11, mixed mode)

2.开发工具及系统环境:
    IntelliJ IDEA 2018.1.7 (Ultimate Edition)
    Build #IU-181.5540.23, built on November 12, 2018
    Licensed to 陈 楠
    Subscription is active until October 13, 2019
    For educational use only.
    JRE: 1.8.0_152-release-1136-b43 amd64
    JVM: OpenJDK 64-Bit NetworkExperiment7.Server VM by JetBrains s.r.o
    Windows 10 10.0

 */

import java.io.DataInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receiver implements Runnable { //实现Runnable接口
    private DataInputStream dataInputStream;    //输入流
    private String character;                   //角色

    public Receiver(DataInputStream dataInputStream, String character) {
        super();
        this.dataInputStream = dataInputStream; //赋值输入流
        this.character = character;               //赋值角色
    }

    @Override   //实写run方法
    public void run() {
        while (true) {      //无限循环
            try {
                String pattern = "yyyy-MM-dd HH:mm:ss"; //定义时间格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);//定义时间格式
                String date = simpleDateFormat.format(new Date());//生成时间
                String msg = dataInputStream.readUTF();//从输入流中读取数据
                System.out.println(date + " [" + character + "]: " + msg);//打印接收到的数据
                if (msg.equals("bye"))  //如果接收到的是"bye",结束循环
                {
                    break;
                }
            } catch (IOException e) {
                break;
            }

        }
    }
}
