package toolbox.number;

import toolbox.Variables;

public class RandomNumber {

    public int generateBetween(long lowerBound, long upperBound) {

        return (int) (lowerBound + (int)(Math.random() * ((upperBound - lowerBound) + 1)));
    }

    public String generateOfSize(int size) {

        String numbers = Variables.EN_NUMBER;

        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int)(numbers.length() * Math.random());

            sb.append(numbers.charAt(index));
        }

        return sb.toString();
    }
}