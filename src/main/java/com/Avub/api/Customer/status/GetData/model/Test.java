package com.Avub.api.Customer.status.GetData.model;

import com.Avub.api.Customer.status.GetData.Servise.PasswordEncryptionService;

public class Test {
    public static void main(String[] args) {
        PasswordEncryptionService service = new PasswordEncryptionService();
        /*String rawPassword = "123456";
        String encryptedPassword = service.encryptPassword(rawPassword);
        System.out.println("Encrypted password: " + encryptedPassword);
        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encrypted Password: " + encryptedPassword);
        System.out.println("Password Matches: " + service.matches(rawPassword, encryptedPassword));
        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();*/

        String rawPassword = "123456";
        String encryptedPassword = service.encryptPassword(rawPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encrypted Password: " + encryptedPassword);

        boolean matches = service.matches(rawPassword, encryptedPassword);
        System.out.println("Password Matches: " + matches);

        // Test with wrong password
        boolean doesNotMatch = service.matches("wrongPassword", encryptedPassword);
        System.out.println("Wrong Password Matches: " + doesNotMatch);
    }
}
