package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.repository.CustomerLoan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerLoanController {
    private final CustomerLoan customerLoan;

    public CustomerLoanController(CustomerLoan customerLoan) {
        this.customerLoan = customerLoan;
    }

    @GetMapping("employee-LoanData")
    public List<Map<String, Object>> getCustomerLoanData(@RequestParam String mobileNo){
        return customerLoan.fetchEmployeeLoanData(mobileNo);
    }
}
