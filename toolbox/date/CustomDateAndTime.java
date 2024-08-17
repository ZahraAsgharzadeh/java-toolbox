package toolbox.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CustomDateAndTime {

    public Date getDayBeforeYesterday() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);

        return calendar.getTime();
    }

    public Date get(int amount) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, amount);

        return calendar.getTime();
    }

    public Date getYesterday() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    public Date getToday() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return cal.getTime();
    }

    public Date getTomorrow() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, +1);

        return calendar.getTime();
    }

    public Date getNow() {

        DateFormat dateFormat = new DateFormatter().getDateAndTimeInUTC();

        Date date = new Date();

        String now = dateFormat.format(date);

        try {

            return dateFormat.parse(now);
        } catch (ParseException e) {

            return new Date();
        }
    }

    public Date getTodayOnlyDATE() {

        return new DateConvertor().convertStringToDate(new DateFormatter().getDateInUTC().format(getToday()));
    }
}