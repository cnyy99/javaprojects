import java.io.Serializable;

public class clock implements Serializable {
    private static final long serialVersionUID=2018L;
    private int hour,minute,second;
    public void show(){
        System.out.println(hour+":"+minute+":"+second);
    }

    public clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}
