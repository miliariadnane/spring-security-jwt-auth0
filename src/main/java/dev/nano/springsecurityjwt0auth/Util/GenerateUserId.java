package dev.nano.springsecurityjwt0auth.Util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class GenerateUserId {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0((21GDB{NJ56456csd-sd|cbhjsc@dnsdc@5fds}CD585))";

    public String generateStringId(int lenght) {
        StringBuilder returnValue = new StringBuilder(lenght);

        for(int i=0; i< lenght; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
