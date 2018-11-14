package temp;

import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
    public static void main(String args[]) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2005, 11, 31);
        long milli = calendar.getTimeInMillis();
        long milliInDay = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 365; i++) {
            calendar.setTime(new Date(milli += milliInDay));
            int date = calendar.get(Calendar.DATE);
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            if (date == 13 && day == Calendar.FRIDAY)
                System.out.println(calendar.get(Calendar.MONTH) + 1 + "月");
        }
    }
}
