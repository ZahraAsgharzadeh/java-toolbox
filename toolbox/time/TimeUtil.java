package toolbox.time;

public class TimeUtil {

    private final long millisecondsPerSecond = 1000;
    private final long secondsPerMinute = 60;
    private final long minutesPerHour = 60;

    public long dayToMilliseconds(long day) {

        return hourToMilliseconds(24) * day;
    }

    public long hourToMilliseconds(long hour) {

        return hour * minutesPerHour * secondsPerMinute * millisecondsPerSecond;
    }

    public long minuteToMilliseconds(long minute) {

        return minute * secondsPerMinute * millisecondsPerSecond;
    }

    public long secondToMilliseconds(long second) {

        return second * millisecondsPerSecond;
    }
}