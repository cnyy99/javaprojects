package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JInetAddressTest {
    public static void main(String [] args)
    {
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("通过getLocal()获得本机英特网地址对象:"+local);
            System.out.println("getHostName():"+local.getHostName());
            System.out.println("getHostAddress():"+local.getHostAddress());
            System.out.println();

            String bjfuWeb="www.bjfu.edu.cn";
            InetAddress bjfu = InetAddress.getByName(bjfuWeb);
            System.out.println("通过getLocal()获得本机英特网地址对象:"+bjfu);
            System.out.println("getHostName():"+bjfu.getHostName());
            System.out.println("getHostAddress():"+bjfu.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
