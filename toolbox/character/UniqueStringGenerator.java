package toolbox.character;

import java.text.SimpleDateFormat;
import java.util.Date;
import toolbox.number.RandomNumber;

public class UniqueStringGenerator {

    public String generateByDate() {

        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");

        return ft.format(now) + new RandomNumber().generateOfSize(5);
    }
}