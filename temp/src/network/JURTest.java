package network;

import java.net.MalformedURLException;
import java.net.URL;

public class JURTest {
    public static void main(String [] args)
    {
        try{
            URL url = new URL("http://www.oracle.com/technetwork/java/index.html");
            System.out.println( "URL：" + url );
            System.out.println( "协议：" + url.getProtocol() );
            System.out.println( "主机：" + url.getHost() );
            System.out.println( "端口：" + url.getPort() );
            System.out.println( "默认端口：" + url.getDefaultPort() );
            System.out.println( "路径：" + url.getPath() );
        }
        catch(MalformedURLException e) { e.printStackTrace(); }  // 捕捉并处理勾选异常
    }  }
