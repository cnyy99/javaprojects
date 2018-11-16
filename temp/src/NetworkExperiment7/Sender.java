package NetworkExperiment7;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sender implements Runnable {
    private DataOutputStream dataOutputStream;

    public Sender(DataOutputStream dataOutputStream) {
        super();
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message;
                BufferedReader bf = new BufferedReader(
                        new InputStreamReader(System.in));
                //注意不能直接用DataInputStream来封装标准输入，原因前文已提到
                message = bf.readLine();
                dataOutputStream.writeUTF(message);
            } catch (IOException e) {

                break;
            }

        }
    }
}
