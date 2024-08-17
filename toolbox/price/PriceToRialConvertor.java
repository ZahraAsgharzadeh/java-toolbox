package toolbox.price;

import java.math.BigInteger;

public class PriceToRialConvertor {

    public BigInteger convert(BigInteger price) {

        return price.multiply(BigInteger.valueOf(10));
    }

    public String convertAndSeparate(BigInteger price) {

        BigInteger rialPrice = convert(price);
        return new PriceSeparator().separate(rialPrice);
    }
}