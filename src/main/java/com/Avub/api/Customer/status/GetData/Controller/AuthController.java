package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.AuthenticationService;
import com.Avub.api.Customer.status.GetData.Servise.UserService;
import com.Avub.api.Customer.status.GetData.Servise.User_Service;
import com.Avub.api.Customer.status.GetData.model.CustomerInformation;
import com.Avub.api.Customer.status.GetData.model.CustomerInformationRepository;
import com.Avub.api.Customer.status.GetData.model.JwtUtil;
import com.Avub.api.Customer.status.GetData.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth3")
public class AuthController {
    @Autowired
    private User_Service userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User signed up successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getMobileNumber());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("User signed in successfully");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
