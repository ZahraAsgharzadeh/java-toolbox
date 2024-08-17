package toolbox.character;

import toolbox.Variables;

public class SpecialCharacterRemover {

    private final String replacement = "_";

    public String remove(String text) {
        
        String result = text;

        for (String specialCharacters : Variables.SPECIAL_CHARACTERS) {
            
            if (text.contains(specialCharacters)) {
                result = text.replace(specialCharacters, replacement);
            }
        }

        return result;
    }
}