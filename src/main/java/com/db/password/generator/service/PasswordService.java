package com.db.password.generator.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordService {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*/\\(){}[]:;\"'?!<>-+.";

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSymbols) {
        if (length < 10 || length > 50) {
            throw new IllegalArgumentException("Password length must be between 10 and 50.");
        }

        StringBuilder pool = new StringBuilder();
        if (useUpper) pool.append(UPPER);
        if (useLower) pool.append(LOWER);
        if (useDigits) pool.append(DIGITS);
        if (useSymbols) pool.append(SYMBOLS);

        if (pool.isEmpty()) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(pool.length());
            password.append(pool.charAt(index));
        }

        return password.toString();
    }
}
