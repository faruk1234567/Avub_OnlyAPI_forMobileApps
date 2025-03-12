package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class MyCusController {
    private final CustomerRepository customerRepository;

    public MyCusController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/employee-data")
    public List<Map<String, Object>> getEmployeeData(@RequestParam  ("mobileNo") String mobileNo ){
        System.out.println("Received mobileNo parameter: " + mobileNo);
        /*if (mobileNo == null || mobileNo.isEmpty()) {
            throw new IllegalArgumentException("mobileNo parameter is required");
        }*/
        return customerRepository.fetchEmployeeData(mobileNo);
        //return customerRepository.fetchEmployeeData(mobileNo);


    }
}
