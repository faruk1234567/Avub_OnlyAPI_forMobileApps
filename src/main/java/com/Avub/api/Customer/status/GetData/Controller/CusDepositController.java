package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.repository.CustomerDeposit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController

public class CusDepositController {
    private final CustomerDeposit customerDeposit;

    public CusDepositController(CustomerDeposit customerDeposit) {
        this.customerDeposit = customerDeposit;
    }
    @GetMapping("employee-depositData")
    public List<Map<String, Object>> getCustomerDepositData(@RequestParam  String mobileNo){
        return customerDeposit.fetchEmployeeDepositData(mobileNo);
    }
}
