package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Servise.UserService;
import com.Avub.api.Customer.status.GetData.Servise.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserServiceTest userServiceTest;
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String trimmedUsername = username.trim();
     // String rabib   = password.trim();
        boolean isAuthenticated = userServiceTest.authenticateUser(trimmedUsername, password);
        return isAuthenticated ? "Login successful" : "Invalid username or password";
    }

}
