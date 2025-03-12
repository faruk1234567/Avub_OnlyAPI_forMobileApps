/*
package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.CustomerService;
import com.Avub.api.Customer.status.GetData.model.Customer;


import com.Avub.api.Customer.status.GetData.repository.CustomerRepoImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8098")
@RestController
@RequestMapping("/api")
public class CustomerController {

    */
/*private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }*//*

    private final CustomerRepoImpl customerRepo;

    public CustomerController(CustomerRepoImpl customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/order-details/{mobile_no}")
    public List<Customer> getOrderDetailsByCustomerId(@PathVariable String mobile_no) {
        return customerRepo.getCustomerById(mobile_no);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Customer>> getUserOrders(@PathVariable String userId) {

        List<Customer> results = customerRepo.getCustomerById(userId);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }

}
*/
