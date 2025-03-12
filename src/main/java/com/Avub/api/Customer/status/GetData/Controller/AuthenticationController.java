/*
package com.Avub.api.Customer.status.GetData.Controller;

import com.Avub.api.Customer.status.GetData.Security.AuthenticationRequest;
import com.Avub.api.Customer.status.GetData.Servise.AuthenticationService;
import com.Avub.api.Customer.status.GetData.model.JwtUtil;

import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final JwtUtil jwtUtil;
    private final AuthenticationService authenticationService;

    private final AuthenticationManager authenticationManager;
@Autowired
    public AuthenticationController(JwtUtil jwtUtil, AuthenticationService authenticationService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authenticationService.authenticate(username, password);
    }









    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticationRequest authRequest) {
        // Authenticate user using username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        return jwtUtil.generateToken(authentication.getName());
    }

}
*/
