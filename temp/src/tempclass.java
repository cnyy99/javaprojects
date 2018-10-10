import java.io.*;

public class tempclass {
    public static void main(String args[])throws IOException{
        int x,y;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter x and y");
        x= Integer.valueOf(in.readLine());
        y= Integer.valueOf(in.readLine());
        if(x!=y)
        {
            if(x>y)
            {
                System.out.println("x>y");
            }
            else {
                System.out.println("x<y");
            }
        }
        else
        {
            System.out.println("x=y");
        }
//        int a=0;
//        System.out.println(a);
    }
}
