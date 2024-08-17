package toolbox.date;

import java.text.ParseException;
import java.util.Date;

public class DateConvertor {

    public static final String[] DATE_FORMATS = new String[] {
            DateFormatter.YEAR_MONTH_DAY_SLASH,
            DateFormatter.YEAR_MONTH_DAY_DASH
    };

    public static final String[] DATE_AND_TIME_FORMATS = new String[] {
            DateFormatter.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SLASH,
            DateFormatter.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DASH,
            DateFormatter.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_WITH_T_DASH
    };

    private final DateFormatter dateFormatter = new DateFormatter();

    public String convertDateToString(Date date) {

        return dateFormatter.getDateInUTC().format(date);
    }

    public String convertDateToString(Date date, String format) {

        return dateFormatter.getDateInUTC(format).format(date);
    }

    public Date convertStringToDate(String date) {

        try {

            return dateFormatter.getDateInUTC().parse(date);
        } catch (ParseException e) {

            return new Date();
        }
    }

    public Date convertStringToDateAndTimeWithAllFormatters(String date) {

        for (String DATE_AND_TIME_FORMAT : DATE_AND_TIME_FORMATS) {

            try {

                return dateFormatter.getDateAndTimeInUTC(DATE_AND_TIME_FORMAT).parse(date);
            } catch (ParseException e) {

            }
        }

        return null;
    }

    public Date convertStringToDateWithAllFormatters(String date) {

        for (String DATE_FORMAT : DATE_FORMATS) {

            try {

                return dateFormatter.getDateInUTC(DATE_FORMAT).parse(date);
            } catch (ParseException e) {

            }
        }

        return null;
    }

    public String convertTimeToString(Date date) {

        return dateFormatter.getTimeInTehran(DateFormatter.HOUR_MINUTE).format(date);
    }
}