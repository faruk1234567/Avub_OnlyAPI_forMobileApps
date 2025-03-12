package com.Avub.api.Customer.status.GetData.Servise;

import com.Avub.api.Customer.status.GetData.model.User;
import com.Avub.api.Customer.status.GetData.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private LoginUserRepository loginUserRepository;

    public LoginServiceImpl(LoginUserRepository loginUserRepository) {
        super();
        this.loginUserRepository = loginUserRepository;
    }

    @Override
    public User findPasswordByMobileNumber(String mobileNo) {
        return loginUserRepository.findPasswordByMobileNumber(mobileNo);
    }
}
