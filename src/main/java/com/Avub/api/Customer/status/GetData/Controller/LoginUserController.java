package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.LoginService;
import com.Avub.api.Customer.status.GetData.Servise.LoginUserDetailService;
import com.Avub.api.Customer.status.GetData.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Component
public class LoginUserController {

    LoginUserDetailService loginUserDetailService;

    @GetMapping("/Signup")
    public ResponseEntity<String> register(@RequestParam String mobileNo, @RequestParam String rawPassword) {
        loginUserDetailService.loadUserByUsername(mobileNo);
        return ResponseEntity.ok("Password generated and saved successfully");
    }


}
