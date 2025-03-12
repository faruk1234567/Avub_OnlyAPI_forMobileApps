package com.Avub.api.Customer.status.GetData.Rabib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CusService {
    private final CusRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
@Autowired
    public CusService(CusRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;


    }
    public boolean updatePassword(String mobileNumber, String newPassword){
        String trimmedMobileNumber = mobileNumber.trim();
    CusModel cusModel=repository.findByMobileNumber(trimmedMobileNumber);
        if (cusModel != null) {
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
        CusModel userOne = repository.findByMobileNumber(trimmedMobileNumber);

        if (userOne != null) {
            System.out.println("Stored password hash: " + userOne.getPassword());
            System.out.println("Provided password: " + password);


            if (bCryptPasswordEncoder.matches(password, userOne.getPassword())) {
                return jwtService.generateToken(userOne);
            }

        }

        return null;
    }
}
