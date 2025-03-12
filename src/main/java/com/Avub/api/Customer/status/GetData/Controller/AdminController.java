package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.PasswordService;
import com.Avub.api.Customer.status.GetData.model.CustomerInformation;
import com.Avub.api.Customer.status.GetData.model.CustomerInformationRepository;
import com.Avub.api.Customer.status.GetData.model.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {


   private final PasswordService passwordService;

    public AdminController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }


    @PostMapping("/set-password")
    public ResponseEntity<String> setPassword(@RequestParam String mobileNo, @RequestParam String rawPassword) {
        try {
            passwordService.savePassword(mobileNo, rawPassword);
            return ResponseEntity.ok("Password set successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error setting password");
        }
    }
}
