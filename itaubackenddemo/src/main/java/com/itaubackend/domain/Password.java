package com.itaubackend.domain;

import java.util.HashSet;
import java.util.Set;
public class Password {
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 9) return false;

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        Set<Character> usedChars = new HashSet<>();

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) hasDigit = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (".@%+^&!*-".indexOf(ch) >= 0) hasSpecial = true;

            // Check for repeated characters
            if (!usedChars.add(ch)) return false;
        }

        return hasDigit && hasLower && hasUpper && hasSpecial;
    }

}
