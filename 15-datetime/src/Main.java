import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main{
    public static void main(String[] args) {
        calendarClass();
    }

    static void calendarClass(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Bucharest"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);

        Date date = calendar.getTime();

        SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss");
        SimpleDateFormat shortFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

        System.out.println("Current year: " + year);
        System.out.println("Current month: " + month);
        System.out.println("Current week of year: " + weekOfYear);
        System.out.println("Current week of month: " + weekOfMonth);
        System.out.println("Current day of year: " + dayOfYear);
        System.out.println("Current day of month: " + dayOfMonth);
        System.out.println("Current hour: " + hour);
        System.out.println("Current minute: " + minute);
        System.out.println("Current second: " + second);
        System.out.println("Current millisecond: " + millisecond);

        System.out.println("Current Date and Time(Date Class): " + date);
//        Stie de unde esti
        System.out.println("Current Date and Time(Long Format): " + longFormat.format(date));//2026-martie-05 14:59:08
        System.out.println("Current Date and Time(Short Format): " + shortFormat.format(date));//26-03-05 14:59

        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2004, Calendar.JANUARY, 4);
        System.out.println("MY BIRTH DATE: " + birthDate.getTime());

        //Calendar Class is mutable
        System.out.println("YEAR: " + birthDate.get(Calendar.YEAR));
    }
}
