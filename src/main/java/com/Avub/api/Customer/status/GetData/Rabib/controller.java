/*
package com.Avub.api.Customer.status.GetData.Rabib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/log")
public class controller {

    @Autowired
    private service userService;

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestParam("mobileNumber") String mobileNumber, @RequestParam String newPassword) {
        System.out.println("Received mobile number: " + mobileNumber);
        System.out.println("Received new password: " + newPassword);
        boolean isUpdated = userService.updatePassword(mobileNumber.trim(), newPassword);
        if (isUpdated) {
            return ResponseEntity.ok("Password updated successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String mobileNumber, @RequestParam String password) {
        System.out.println("Login attempt with mobile number: " + mobileNumber);
        System.out.println("Password provided: " + password);
        String token = userService.login(mobileNumber, password);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
*/
