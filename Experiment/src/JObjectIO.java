import java.io.*;
import java.time.Clock;

public class JObjectIO {
    public static void main(String []args)
    {
        fwrite("d:/obj-io.dat");
        fread("d:/obj-io.dat");
    }
    static void fwrite(String fileName)
    {
        try{
            FileOutputStream fos=new FileOutputStream(fileName);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            clock c1 = new clock(8,30,15);
            clock c2 = new clock(10,30,15);
            oos.writeObject(c1);
            oos.writeObject(c2);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void fread(String fileName)
    {
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            clock c1 = (clock)ois.readObject();
            clock c2 = (clock)ois.readObject();
            c1.show();
            c2.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
