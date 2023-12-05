package utils;

import lombok.experimental.UtilityClass;
import java.util.Random;

@UtilityClass
public class RandomUtils {

    public static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int generateRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            randomString.append(CAPITAL_LETTERS.charAt(RandomUtils.generateRandomNumber(CAPITAL_LETTERS.length())));
            randomString.append(CAPITAL_LETTERS.toLowerCase().charAt(RandomUtils.generateRandomNumber(CAPITAL_LETTERS.length())));
        }

        return randomString.toString();
    }

    public static String getRandomChar(String randString) {
        int k = generateRandomNumber(randString.length());
        return Character.toString(randString.charAt(k));
    }
}
