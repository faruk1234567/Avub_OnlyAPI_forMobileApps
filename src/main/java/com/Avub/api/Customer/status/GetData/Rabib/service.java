/*
package com.Avub.api.Customer.status.GetData.Rabib;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class service {



    private final CusRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
@Autowired
    public service(CusRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public boolean updatePassword(String mobileNumber, String newPassword) {
        String trimmedMobileNumber = mobileNumber.trim();
        System.out.println("Updating password for mobile number: " + mobileNumber);
        model user = repository.findByMobileNumber(trimmedMobileNumber);
        if (user != null) {
            String hashedPassword = bCryptPasswordEncoder.encode(newPassword);
            System.out.println("Hashed password: " + hashedPassword);
            repository.updatePassword(trimmedMobileNumber, hashedPassword);
            return true;
        }else {
            System.out.println("User not found for mobile number: " + trimmedMobileNumber);
        }
        return false;
    }

    public String login(String mobileNumber, String password) {
        String trimmedMobileNumber = mobileNumber.trim();
        System.out.println("Login attempt with mobile number: " + mobileNumber);
        model user = repository.findByMobileNumber(trimmedMobileNumber);

        if (user != null) {
            System.out.println("Stored password hash: " + user.getPassword());
            System.out.println("Provided password: " + password);


            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return jwtService.generateToken(user);
            }

        }

        return null;
    }
}
*/
