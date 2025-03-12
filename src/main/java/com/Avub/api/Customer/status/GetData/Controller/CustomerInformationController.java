package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.CustomerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerInformationController {
 /*   @Autowired
    private CustomerInformationService service;

    @PutMapping("/update-password")
    public String updatePassword(@RequestParam String mobile_no, @RequestParam String newPassword) {
        return service.updatePasswordByMobileNo(mobile_no, newPassword);
    }*/
}
