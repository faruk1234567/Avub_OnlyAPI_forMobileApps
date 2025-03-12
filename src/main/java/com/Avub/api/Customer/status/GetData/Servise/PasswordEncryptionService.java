package com.Avub.api.Customer.status.GetData.Servise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptionService {
    private static final Logger logger = LoggerFactory.getLogger(PasswordEncryptionService.class);
    private final PasswordEncoder passwordEncoder;

    public PasswordEncryptionService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encryptPassword(String password) {
        String encryptedPassword = passwordEncoder.encode(password);
        logger.debug("Encrypted password: {}", encryptedPassword);
        return encryptedPassword;
      //  return passwordEncoder.encode(password);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        boolean isMatch = passwordEncoder.matches(this.encryptPassword(rawPassword), encodedPassword);
        logger.debug("Password match result for rawPassword: {} and encodedPassword: {}: {}", rawPassword, encodedPassword, isMatch);
        return isMatch;

    }

}
