package toolbox.date;

import java.util.Date;

import toolbox.date.persianDate.PersianDate;
import toolbox.date.persianDate.PersianDateFormat;

/**
 * reference for pattern : https://github.com/samanzamani/PersianDate
 */
public class PersianDateConvertor {

    private final String DATE_PATTERN = "Y/m/d";

    public String convertDateAndTime(Date date) {

        PersianDate persianDate = new PersianDate(date);
        PersianDateFormat persianDateFormat = new PersianDateFormat(DATE_PATTERN);

        String convertedDate = persianDateFormat.format(persianDate);
        String convertedTime = new DateFormatter().getTimeInTehran(DateFormatter.HOUR_MINUTE_SECOND).format(date);

        return convertedDate + "-" + convertedTime;
    }

    public String convertDate(Date date) {

        PersianDate persianDate = new PersianDate(date);
        PersianDateFormat persianDateFormat = new PersianDateFormat(DATE_PATTERN);

        return persianDateFormat.format(persianDate);
    }
}