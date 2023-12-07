package com.itaubackend.services;

import com.itaubackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class PasswordService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    private Object userService;

    public static void main(String[] args) {
        // Test the method with different passwords
        System.out.println(isValidPassword("aa")); // false
        System.out.println(isValidPassword("aB1@aaaa")); // false
        System.out.println(isValidPassword("aB1@aaaaa")); // true
        // Add more tests as needed
    }
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

