import java.util.Timer;

public class JTimerTest {
    public static void main(String []args)
    {
        Timer t = new Timer("Show time");

        ShowTime st= new ShowTime();
        t.schedule(st,0,2000);
        while(st.count<5)
        {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t.cancel();

    }
}

