package toolbox;

import java.util.Arrays;

public class EnumUtil {

    public <T extends Enum<T>> T getEnumKeyFromValue(Class<T> enumClass, String enumValue) {

        return Arrays.stream(enumClass.getEnumConstants())
                .filter(value -> value.toString().equals(enumValue))
                .findFirst()
                .orElse(null);
    }

    public <T extends Enum<T>> boolean isValidEnumValue(String input, Class<T> enumClass) {

        try {

            Enum.valueOf(enumClass, input);
            return true;

        } catch (Exception e) {

            return false;
        }
    }
}