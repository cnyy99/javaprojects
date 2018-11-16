package NetworkExperiment7;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Printer implements Runnable {
    private DataInputStream dataInputStream;
    private String character;
    public Printer(DataInputStream dataInputStream,String character) {
        super();
        this.dataInputStream = dataInputStream;
        this.character=character;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String pattern = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                String msg = dataInputStream.readUTF();
                System.out.println(date+" [" + character + "]: " + msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
