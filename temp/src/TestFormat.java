import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFormat {
    public static void main(String []args)
    {
        Date nowTime=new Date();
        SimpleDateFormat form = new SimpleDateFormat("'time'(时间是: )yyyy年-MM-dd");
        System.out.println(form.format(nowTime));
    }
}
