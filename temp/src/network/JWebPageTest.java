package network;

import java.net.*;  // 导入java.net网络包中的类
import java.io.*;     // 导入java.io输入输出流包中的类
public class JWebPageTest {                         // 测试类：读取网站里的网页文件（html）
    public static void main(String [] args) {  // 主方法
        try {  // 处理可能出现的勾选异常IOException
            URL url = new URL("http://www.bjfu.edu.cn");
            System.out.println("从网页读取信息: " +url);
            InputStreamReader in = new InputStreamReader( url.openStream() );
            char cbuf[] = new char[300];  // 只读300个字符
            int len = in.read(cbuf);
            for (int n = 0; n < len; n++)
                System.out.print( cbuf[n]);
            System.out.print("......\n以上是从网页读取的原始信息。");
            System.out.println( "字符编码是：" +in.getEncoding() );
            in.close();
        }
        catch(IOException e) { e.printStackTrace(); }  // 捕捉并处理勾选异常
    }  }
