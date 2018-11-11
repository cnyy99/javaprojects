import java.io.*;

public class JbufferwrTEST {
    public  static final String String =null;
    public static void main(String []args)
    {
        fwrite("d:/bfwr.txt");
        fread("d:/bfwr.txt");
    }
    static void fwrite(String filename)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write("fsa\r\n");
            bw.write("fsa234\r\n");
            bw.write("fsa423");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void fread(String filename){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s;
            while((s=br.readLine())!=null)
            {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
