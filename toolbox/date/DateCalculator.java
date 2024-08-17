package toolbox.date;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateCalculator {

    private final DateFormatter dateFormatter = new DateFormatter();

    public List<Date> getDaysBetweenDates(Date startDate, Date endDate) {

        List<Date> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        while (calendar.getTime().before(endDate)) {
            Date date = calendar.getTime();
            String formattedDate = dateFormatter.getDateAndTimeInUTC().format(date);

            try {

                dates.add(dateFormatter.getDateAndTimeInUTC().parse(formattedDate));
            } catch (ParseException e) {

            }

            calendar.add(Calendar.DATE, 1);
        }

        dates.add(endDate);
        return dates;
    }

    public long getTimeDifference(Date oldDate, Date newDate) {

        return TimeUnit.MILLISECONDS.toMillis(newDate.getTime() - oldDate.getTime());
    }

    public int getDaysDifference(Date from, Date to) {

        Calendar day1 = Calendar.getInstance();
        Calendar day2 = Calendar.getInstance();
        day1.setTime(from);
        day2.setTime(to);

        int yearDiff = day1.get(Calendar.YEAR) - day2.get(Calendar.YEAR);
        int dayOfYearDiff = day1.get(Calendar.DAY_OF_YEAR) - day2.get(Calendar.DAY_OF_YEAR);

        return Math.abs(yearDiff * 365 + dayOfYearDiff);
    }

    public Date plusDay(Date date, int count) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, count);
        return calendar.getTime();
    }
}