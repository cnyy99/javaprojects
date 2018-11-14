package temp;

import java.util.Date;

public class TestDate {
    public static void main(String []args)
    {
        Date date1=new Date();
        Date date2=new Date(System.currentTimeMillis());
        System.out.println(date1);
        System.out.println(date2);
    }
}
