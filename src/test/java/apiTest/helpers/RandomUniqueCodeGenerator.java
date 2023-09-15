package apiTest.helpers;
import java.security.SecureRandom;

public class RandomUniqueCodeGenerator {
    private static String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 8;

    private static SecureRandom random = new SecureRandom();

    public static String generateRandomCode() {
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            code.append(randomChar);
            CHARACTERS = CHARACTERS.substring(0, randomIndex) + CHARACTERS.substring(randomIndex + 1);
        }

        return code.toString();
    }
}
