package NetworkExperiment7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s =null;
        try{
            ss = new ServerSocket(7777);
            System.out.println("Server listen at port:7777...");
            s = ss.accept();
            String ip = s.getInetAddress().toString();
            ip = ip.substring(ip.indexOf("/")+1);
            System.out.println(ip+" has connected...");

            OutputStream outputStream = s.getOutputStream();
            InputStream inputStream = s.getInputStream();

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            Sender sender = new Sender(dataOutputStream);
            Printer  printer = new Printer(dataInputStream,"Server");

            new Thread(sender).start();
            new Thread(printer).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
