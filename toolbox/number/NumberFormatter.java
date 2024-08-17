package toolbox.number;

public class NumberFormatter {

    /** old method which it couldn't support arabic numbers and it supports only persian and english numbers
     *
     public String convertNumToEnNum(String number) {

     for (int i = 0; i <= 9; i++) {
     number = number.replace((char) (1776 + i), (char) (48 + i));
     }

     return number;
     }
     */

    public String convertNumToEnNum(String number) {

        if (number != null) {

            char[] chars = new char[number.length()];

            for (int i = 0; i < number.length(); i++) {

                char ch = number.charAt(i);

                if (ch >= 0x0660 && ch <= 0x0669) {

                    ch -= 0x0660 - '0';
                } else if (ch >= 0x06f0 && ch <= 0x06F9) {

                    ch -= 0x06f0 - '0';
                }

                chars[i] = ch;
            }

            return new String(chars);
        }

        return number;
    }
}