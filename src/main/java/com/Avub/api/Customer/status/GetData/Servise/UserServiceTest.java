package com.Avub.api.Customer.status.GetData.Servise;

import com.Avub.api.Customer.status.GetData.model.User;
import com.Avub.api.Customer.status.GetData.repository.UserRepositoryTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceTest implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

   // @Autowired
    private final  UserRepositoryTest userRepositoryTest;
   // @Autowired
    private final PasswordEncryptionService passwordEncryptionService;

    public UserServiceTest(UserRepositoryTest userRepositoryTest, PasswordEncryptionService passwordEncryptionService) {
        this.userRepositoryTest = userRepositoryTest;
        this.passwordEncryptionService = passwordEncryptionService;
    }

    public boolean authenticateUser(String mobileNumber, String password) {
        String trimmedMobileNumber = mobileNumber.trim();
        logger.debug("Original mobileNumber: '{}', Trimmed mobileNumber: '{}'", mobileNumber, trimmedMobileNumber);


        User user = userRepositoryTest.findByMobileNumber(trimmedMobileNumber).orElse(null);
        if (user != null) {
            boolean isAuthenticated = passwordEncryptionService.matches(password, user.getPassword());
            logger.debug("User found. Authentication result: {}", isAuthenticated);
            logger.debug("Password match result: {}", passwordEncryptionService.matches(password, user.getPassword()));
            return isAuthenticated;
            //return passwordEncryptionService.matches(password, user.getPassword());
        }
        logger.debug("User not found for mobileNumber:{}", trimmedMobileNumber);
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
        String mobTwo = mobileNumber.trim();
        logger.debug("Loading user by mobileNumber: {}", mobTwo);
        User user = userRepositoryTest.findByMobileNumber(mobTwo).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        logger.debug("User fetched from repository: {}", user);
        return new org.springframework.security.core.userdetails.User(user.getMobileNumber(), user.getPassword(), new ArrayList<>());
    }
}
