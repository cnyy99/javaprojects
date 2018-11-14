package network;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class JTimeServerST {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("HelloServer started at 8000");
            while (true) {
                Socket s = ss.accept();
                System.out.println("\n收到一个服务请求,建立了TCP连接");
                System.out.println(s.getInetAddress() + ":" + s.getPort());
                timeService(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timeService(Socket s) {
        InputStreamReader in = null;
        OutputStreamWriter out = null;
        try {
            in = new InputStreamReader(s.getInputStream());
            char[] buf = new char[7];
            in.read(buf, 0, buf.length);
            String request = new String(buf);
            System.out.println("客户端的请求是:" + request);
            System.out.println("    其编码是:" + in.getEncoding());
            out = new OutputStreamWriter(s.getOutputStream());
            LocalDateTime t = LocalDateTime.now();
            String response = String.format("Hello,%s!%s", request, t);
            out.write(response, 0, response.length());
            out.flush();
            System.out.println("返回客户端的响应是:" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
