import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main{
    public static void main(String[] args) {
        period();
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
        birthDate.add(Calendar.YEAR, 22);
        System.out.println("22 years later : " + birthDate.get(Calendar.YEAR));
    }

    static void localDate(){
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);
        int year = date.getYear();
        int monthValue = date.getMonthValue();
        int dayOfYear = date.getDayOfMonth();
        System.out.println(dayOfYear + "-" + monthValue + "-" + year);
        Month month = date.getMonth();
        System.out.println("Current month: " + month);
        DayOfWeek dayOfWeek =  date.getDayOfWeek();
        System.out.println("Day of the week: " + dayOfWeek);

        Calendar calendar = Calendar.getInstance();
        System.out.println("Day of the week in Calendar : " + calendar.get(Calendar.DAY_OF_WEEK));

        LocalDate threeWeeksAgo = date.minusWeeks(3);
        System.out.println("3 weeks ago: " + threeWeeksAgo);

        LocalDate fiveDaysLater = date.plusDays(5);
        System.out.println("5 days later: " + fiveDaysLater);

        //localDate class is immutable
        System.out.println("Current date: " + date);
        date.plusDays(10);//Current date: 2026-03-06
        date = date.plusDays(10);
        System.out.println("Current date: " + date);//Current date: 2026-03-16

        LocalDate weddingDate = LocalDate.of(2032, Month.APRIL, 06);
        System.out.println("Wedding Date: " + weddingDate );

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Formatted : " + format.format(weddingDate));

        System.out.println("is wedding date after current date ? " + (weddingDate.isBefore(date) ? "Da" : "Nu"));


    }

    static void localTime(){
        LocalTime time = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");

        System.out.println("Current time: " + time);

        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        int nanosecond = time.getNano();

        System.out.println("Current hour: " +hour);
        System.out.println("Current minute: " + minute);
        System.out.println("Current second: " + second);
        System.out.println("Current nanosecond: " + nanosecond);

        LocalTime twoHoursAgo = time.minusHours(2);
        System.out.println("2 hours ago: " + twoHoursAgo);

        LocalTime thirtyMinutesLater = time.plusMinutes(30);
        System.out.println("30 minutes later: " + format.format(thirtyMinutesLater));

        System.out.println("Immutable: " + time);

        LocalTime appointmentTime = LocalTime.of(15, 30 , 0);
        System.out.println("Appointment Time: " + appointmentTime);

        appointmentTime.isBefore(LocalTime.now());



    }

    static void localDateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date Time" + dateTime);

        int year = dateTime.getYear();
        int second = dateTime.getSecond();
        System.out.println("Current year: " + year);
        System.out.println("Current second: " + second);

        LocalDateTime mixedTime = dateTime.plusDays(3).minusMonths(2);
        System.out.println("Mixed time: " + mixedTime);

        LocalDateTime birthday = LocalDateTime.of(2004,12, 6, 23, 30,0);
        System.out.println("Birthday " + birthday);

        System.out.println("is my birthday before current date time ? " + birthday.isBefore(dateTime));

    }

    static void period(){
        Period period = Period.of(2,04,0);
        System.out.println("Period : " + period);

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date  " + currentDate);

        LocalDate nextDate = currentDate.plus(period);
        System.out.println("Next Date " + nextDate);
    }
}
