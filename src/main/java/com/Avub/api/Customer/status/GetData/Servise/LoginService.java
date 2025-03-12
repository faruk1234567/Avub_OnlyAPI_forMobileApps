package com.Avub.api.Customer.status.GetData.Servise;


import com.Avub.api.Customer.status.GetData.model.User;
import org.springframework.stereotype.Service;


public interface LoginService  {
    User findPasswordByMobileNumber(String mobileNo);



}
