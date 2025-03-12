package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.model.Customer;
import com.Avub.api.Customer.status.GetData.repository.CustomerUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerUserController {
    private final CustomerUserRepository customerUserRepository;

    public CustomerUserController(CustomerUserRepository customerUserRepository) {
        this.customerUserRepository = customerUserRepository;
    }
    @GetMapping("/user")
    public ResponseEntity<?> getEmployeeData(@RequestParam("mobileNo") String mobileNo) {
        try {
            System.out.println("Received mobileNo parameter: " + mobileNo);

            if (mobileNo == null || mobileNo.trim().isEmpty()) {
                return new ResponseEntity<>("mobileNo parameter is required", HttpStatus.BAD_REQUEST);
            }

            List<Map<String, Object>> userData = customerUserRepository.findUserByMobile(mobileNo);

            if (userData.isEmpty()) {
                return new ResponseEntity<>("The Mobile number you insert is not available", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(userData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }

