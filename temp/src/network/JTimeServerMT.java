package network;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JTimeServerMT {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("HelloServer started at 8000");
            while (true) {
                Socket s = ss.accept();
                System.out.println("\n收到一个服务请求,建立了TCP连接");
                System.out.println(s.getInetAddress() + ":" + s.getPort());
                TimeService a = new TimeService(s);
                Thread t = new Thread(a);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
