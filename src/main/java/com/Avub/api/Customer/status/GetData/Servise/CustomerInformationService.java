package com.Avub.api.Customer.status.GetData.Servise;

import com.Avub.api.Customer.status.GetData.model.CustomerInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerInformationService {
    @Autowired
    private CustomerInformationRepository repository;

    /*@Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

    /*@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public String updatePasswordByMobileNo(String mobileNo, String newPassword) {
        // Trim the mobile number to remove any leading/trailing whitespaces
        mobileNo = mobileNo.trim();

        return repository.findByMobileNo(mobileNo)
                .map(customer -> {
                    customer.setCusPassword(passwordEncoder.encode(newPassword));
                    repository.save(customer);
                    return "Password updated successfully";
                })
                .orElse("Customer not found");
    }*/
}

