package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/save-password")
    public ResponseEntity<String> savePassword(@RequestParam String mobileNo,@RequestParam String rawPassword) {
        //String trimmedMobileNo = mobileNo.trim();
        userService.generateAndSavePassword(mobileNo, rawPassword);
        return ResponseEntity.ok("Password generated and saved successfully");
    }
}
