package com.Avub.api.Customer.status.GetData.Servise;

import com.Avub.api.Customer.status.GetData.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private  final UserRepository userRepository;

   private final BCryptPasswordEncoder passwordEncoder;

    public PasswordService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /* @Bean
     public BCryptPasswordEncoder bCryptPasswordEncoder() {
         return new BCryptPasswordEncoder();
     }*/
    public void savePassword(String mobileNo, String rawPassword) {
        try {
            mobileNo = mobileNo.trim();
            // String encodedPassword = "{noop}" + rawPassword;
            String encodedPassword = passwordEncoder.encode(rawPassword);
            userRepository.updatePasswordByMobileNo(mobileNo, encodedPassword);
        }catch (Exception e){
            throw new RuntimeException("Error encoding password", e);
        }
    }
    public boolean authenticate(String mobileNo, String rawPassword) {
        try {
            String storedPassword = userRepository.findPasswordByMobileNo(mobileNo);
            return passwordEncoder.matches(rawPassword, storedPassword);
        }catch (Exception e){
            throw new RuntimeException("Error authenticating password", e);


        }
    }
}
