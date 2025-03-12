package com.Avub.api.Customer.status.GetData.Rabib;

import com.Avub.api.Customer.status.GetData.Servise.PasswordEncryptionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/log")
public class CusController {

    @Autowired
    private CusService userService;
    private static final Logger logger = LoggerFactory.getLogger(CusController.class);

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
  /*  @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam ("mobileNumber") String mobileNumber, @RequestParam("password") String password) {
        System.out.println("Login attempt with mobile number: " + mobileNumber);
        System.out.println("Password provided: " + password);
        String token = userService.login(mobileNumber, password);
        if (token != null) {
            LoginResponse response = new LoginResponse(token, mobileNumber);
           // return ResponseEntity.ok("Login successful. Token: " + token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Login unsuccessful. Invalid credentials.");
    }*/
  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
      String mobileNumber = loginRequest.getMobileNumber();
      String password = loginRequest.getPassword();
      logger.info("Received mobile number: {}", mobileNumber);
      logger.info("Received password: {}", password);
      String token = userService.login(mobileNumber, password);
      if (token != null) {
          LoginResponse response = new LoginResponse(token, mobileNumber);
          return ResponseEntity.ok(response);
      }
      return ResponseEntity.status(401).body("Login unsuccessful. Invalid credentials.");
  }

}
