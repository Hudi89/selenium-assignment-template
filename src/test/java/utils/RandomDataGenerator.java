package utils;

import java.util.UUID;

public class RandomDataGenerator {

    public static String randomUsername() {
        return "user_" + UUID.randomUUID();
    }

    public static String randomPassword() {
        return UUID.randomUUID().toString();
    }

}
