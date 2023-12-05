package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PasswordUtils {

    private static final String NUMERALS = "0123456789";
    private static final String CYRILLIC_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯ";

    public static String generateValidPassword(String email, int expectedLength) {

        StringBuilder password = new StringBuilder();

        password.append(RandomUtils.getRandomChar(RandomUtils.CAPITAL_LETTERS)); // Add capital letter
        password.append(RandomUtils.getRandomChar(NUMERALS)); // Add numeral
        password.append(RandomUtils.getRandomChar(email)); // Add character from email
        password.append(RandomUtils.getRandomChar(CYRILLIC_CHARACTERS)); // Add cyrillic character

        while (password.length() < expectedLength) {
            password.append(RandomUtils.getRandomChar(RandomUtils.CAPITAL_LETTERS));
        }

        return password.toString();
    }
}
