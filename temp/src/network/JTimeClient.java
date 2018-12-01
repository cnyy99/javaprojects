package network;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class JTimeClient {
    public static void main(String []args)
    {
        Socket s = null;
        InputStreamReader in =null;
        OutputStreamWriter  out = null;
        try{
            s= new Socket ("localhost",8000);
            System.out.println("localhost:8000 connected......");
            out= new OutputStreamWriter(s.getOutputStream());
            int id = (int)(Math.random()*10);
            String request = "NetworkExperiment7.Client"+id;
            out.write(request,0,request.length());
            out.flush();
            System.out.println("发送的服务请求是:"+request);
            in = new InputStreamReader(s.getInputStream());
            char []buf= new char[100];
            in.read(buf,0,buf.length);
            String response = new String(buf);
            System.out.println("接受的服务响应是:"+ response);
            System.out.println("    其编码是:"+in.getEncoding());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(in!=null)
                {
                    in.close();
                }
                if(out!=null)
                {
                    out.close();
                }
                if(s!=null)
                {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
