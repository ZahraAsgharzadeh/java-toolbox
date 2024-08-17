package toolbox.number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class NumberToPersianLetter {

    private final String splitter;
    ArrayList<ArrayList<String>> words = new ArrayList<>();

    /**
     * constructor
     * build the needed data
     */
    public NumberToPersianLetter() {
        ArrayList<String> temp = new ArrayList<>();

        temp.add("");
        temp.add("یک");
        temp.add("دو");
        temp.add("سه");
        temp.add("چهار");
        temp.add("پنج");
        temp.add("شش");
        temp.add("هفت");
        temp.add("هشت");
        temp.add("نه");
        words.add(temp);

        temp = new ArrayList<>();
        temp.add("ده");
        temp.add("يازده");
        temp.add("دوازده");
        temp.add("سيزده");
        temp.add("چهارده");
        temp.add("پانزده");
        temp.add("شانزده");
        temp.add("هفده");
        temp.add("هجده");
        temp.add("نوزده");
        words.add(temp);
        temp = new ArrayList<>();
        temp.add("");
        temp.add("");
        temp.add("بيست");
        temp.add("سي");
        temp.add("چهل");
        temp.add("پنجاه");
        temp.add("شصت");
        temp.add("هفتاد");
        temp.add("هشتاد");
        temp.add("نود");
        words.add(temp);

        temp = new ArrayList<>();
        temp.add("");
        temp.add("يکصد");
        temp.add("دويست");
        temp.add("سيصد");
        temp.add("چهارصد");
        temp.add("پانصد");
        temp.add("ششصد");
        temp.add("هفتصد");
        temp.add("هشتصد");
        temp.add("نهصد");
        words.add(temp);

        temp = new ArrayList<>();
        temp.add("");
        temp.add(" هزار ");
        temp.add(" ميليون ");
        temp.add(" ميليارد ");
        temp.add(" بيليون ");
        temp.add(" بيليارد ");
        temp.add(" تريليون ");
        temp.add(" تريليارد ");
        temp.add(" کوآدريليون ");
        temp.add(" کادريليارد ");
        temp.add(" کوينتيليون ");
        temp.add(" کوانتينيارد ");
        temp.add(" سکستيليون ");
        temp.add(" سکستيليارد ");
        temp.add(" سپتيليون ");
        temp.add(" سپتيليارد ");
        temp.add(" اکتيليون ");
        temp.add(" اکتيليارد ");
        temp.add(" نانيليون ");
        temp.add(" نانيليارد ");
        temp.add(" دسيليون ");
        words.add(temp);

        splitter = " و ";
    }

    /**
     * add extra zeros to beginning of number so the remainder of number's length to 3 would be 0
     * e.g : 1213 => 001213
     *
     * @param number
     * @return
     */
    public ArrayList<String> prepareNumber(String number) {
        int length = number.length() % 3;
        String resultNumber = number;
        if (length == 1) {
            resultNumber = "00" + number;
        } else if (length == 2) {
            resultNumber = "0" + number;
        }
        return (ArrayList<String>) splitStringBySize(resultNumber, 3);
    }

    private static Collection<String> splitStringBySize(String str, int size) {
        ArrayList<String> split = new ArrayList<>();
        for (int i = 0; i < str.length() / size; i++) {
            split.add(str.substring(i * size, Math.min((i + 1) * size, str.length())));
        }
        return split;
    }

    /**
     * example : 111 => صد و یازده
     *
     * @param num
     * @return
     */
    public String threeNumbersToLetter(String num) {
        if ("".equals(num)) {
            return "";
        }
        int parsedInt = Integer.parseInt(num);
        if (parsedInt < 10) {
            return words.get(0).get(parsedInt);
        }
        if (parsedInt < 20) {
            return words.get(1).get(parsedInt - 10);
        }
        if (parsedInt < 100) {
            int one = parsedInt % 10;
            int ten = (parsedInt - one) / 10;
            if (one > 0) {
                return words.get(2).get(ten) + splitter + words.get(0).get(one);
            }
            return words.get(2).get(ten);
        }
        int one = parsedInt % 10;
        int hundreds = (parsedInt - (parsedInt % 100)) / 100;
        int ten = (parsedInt - ((hundreds * 100) + one)) / 10;
        ArrayList<String> out = new ArrayList<>();
        out.add(words.get(3).get(hundreds));
        int secondPart = ((ten * 10) + one);
        if (secondPart > 0) {
            if (secondPart < 10) {
                out.add(words.get(0).get(secondPart));
            } else if (secondPart < 20) {
                out.add(words.get(1).get(secondPart - 10));
            } else {
                out.add(words.get(2).get(ten));
                if (one > 0) {
                    out.add(words.get(0).get(one));
                }
            }
        }
        return String.join(splitter,out);

    }

    /**
     * e.g: 1424124 : یک میلیون و چهارصد و بیست و چهار هزار و یکصد و بیست و چهار
     *
     * @param input
     * @return
     */
    public String getParsedString(String input) {
        try {
            String zero = "صفر";
            if ("0".equals(input)) {
                return zero;
            }
            if (input.length() > 66) {
                return "";
            }
            //using big decimal in order to convert persian numbers .
            //replace all part is used to remove all the non numeric characters
            String processedInput = (new BigDecimal(input.replaceAll("[^\\d.]", ""))).toString();

            ArrayList<String> splittedNumber = prepareNumber(processedInput);
            ArrayList<String> result = new ArrayList<>();
            int splitLength = splittedNumber.size();
            for (int i = 0; i < splitLength; ++i) {
                String sectionTitle = words.get(4).get((splitLength - (i + 1)));
                String converted = threeNumbersToLetter(splittedNumber.get(i));
                if (!"".equals(converted)) {
                    result.add(converted + sectionTitle);
                }
            }
            return String.join(splitter,result);

        } catch (Exception e) {
            return "";
        }
    }
}