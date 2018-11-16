package NetworkExperiment7;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String []args)
    {
        Socket s= null;
        try{
            s = new Socket("127.0.0.1",7777);
            System.out.println("localhost:7777 connected......");
            OutputStream outputStream = s.getOutputStream();
            InputStream inputStream = s.getInputStream();

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            Sender sender = new Sender(dataOutputStream);
            Printer  printer = new Printer(dataInputStream,"Client");

            new Thread(sender).start();
            new Thread(printer).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
