package network;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeService implements Runnable {
    private Socket s = null;
    TimeService(Socket S)
    {
        s=S;
    }

    @Override
    public void run() {
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
