package com.Avub.api.Customer.status.GetData.Servise;

import com.Avub.api.Customer.status.GetData.Security.LoginUserDetails;
import com.Avub.api.Customer.status.GetData.model.User;
import com.Avub.api.Customer.status.GetData.repository.LoginUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;

public class LoginUserDetailService implements UserDetailsService {
    private LoginUserRepository loginUserRepository;

    public LoginUserDetailService(LoginUserRepository loginUserRepository) {
        super();
        this.loginUserRepository = loginUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= loginUserRepository.findPasswordByMobileNumber(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new LoginUserDetails(user.getMobileNumber(), user.getPassword(), authorities());
    }

    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
    }

