package toolbox.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateFormatter {

    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";
    public static final String HOUR_MINUTE = "HH:mm";
    public static final String YEAR_MONTH_DAY_DASH = "yyyy-MM-dd";
    public static final String YEAR_MONTH_DAY_SLASH = "yyyy/MM/dd";
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DASH = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_WITH_T_DASH = "yyyy-MM-dd'T'HH:mm:ss";

    public DateFormat getDateInUTC() {

        DateFormat dateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_SLASH);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZoneVariables.UTC));

        return dateFormat;
    }

    public DateFormat getDateInUTC(String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZoneVariables.UTC));

        return dateFormat;
    }

    public DateFormat getDateAndTimeInUTC() {

        DateFormat dateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SLASH);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZoneVariables.UTC));

        return dateFormat;
    }

    public DateFormat getDateAndTimeInUTC(String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZoneVariables.UTC));

        return dateFormat;
    }

    public DateFormat getDateAndTimeInTehran() {

        DateFormat dateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DASH);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZoneVariables.Tehran));

        return dateFormat;
    }

    public DateFormat getTimeInTehran(String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZoneVariables.Tehran));

        return dateFormat;
    }
}