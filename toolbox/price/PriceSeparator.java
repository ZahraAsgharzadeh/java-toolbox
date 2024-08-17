package toolbox.price;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class PriceSeparator {

    public String separate(BigInteger price) {

        if (price == null) {
            return "0";
        }

        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(price);
    }

    public String separateWithToman(BigInteger price) {

        return separate(price) + " " + "تومان";
    }
}