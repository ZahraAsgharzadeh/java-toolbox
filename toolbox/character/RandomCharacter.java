package toolbox.character;

import toolbox.Variables;

public class RandomCharacter {

    public String generateWithNumbers(int size) {

        String alphaNumericString = Variables.EN_ALPHABET.toLowerCase() + Variables.EN_NUMBER + Variables.EN_ALPHABET.toUpperCase();

        StringBuilder stringBuilder = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());

            stringBuilder.append(alphaNumericString.charAt(index));
        }

        return stringBuilder.toString();
    }

    public String generate(int size) {

        String alphaNumericString = Variables.EN_ALPHABET.toUpperCase();

        StringBuilder stringBuilder = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());

            stringBuilder.append(alphaNumericString.charAt(index));
        }

        return stringBuilder.toString();
    }
}