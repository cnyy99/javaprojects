import java.time.LocalDateTime;
import java.util.TimerTask;

public class ShowTime extends TimerTask {
    int count =0;
    @Override
    public void run() {
        count++;
        System.out.println(count+":"+LocalDateTime.now());
    }
}
