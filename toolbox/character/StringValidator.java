package toolbox.character;

public class StringValidator {

    public static boolean isNullOrEmpty(String string) {

        return string == null || string.trim().isEmpty();
    }

    public static boolean containsIgnoreCase(String content, String string) {

        return content.toLowerCase().contains(string.toLowerCase());
    }
}