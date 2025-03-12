package com.Avub.api.Customer.status.GetData.Servise;

import com.Avub.api.Customer.status.GetData.model.PasswordGenerator;
import com.Avub.api.Customer.status.GetData.model.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PasswordGenerator passwordGenerator;

    public UserService(UserRepository userRepository, PasswordGenerator passwordGenerator) {
        this.userRepository = userRepository;
        this.passwordGenerator = passwordGenerator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void generateAndSavePassword(String mobileNo, String rawPassword) {
        String trimmedMobileNo = mobileNo.trim();
      //  String generatedPassword = passwordGenerator.generatePassword(12); // length of the password
        String encodedPassword = passwordEncoder.encode(rawPassword);
        userRepository.updatePasswordByMobileNo(trimmedMobileNo, encodedPassword);
        // Optionally, you might want to send the password to the user
        // e.g., send an email or SMS with the generated password
    }
}
