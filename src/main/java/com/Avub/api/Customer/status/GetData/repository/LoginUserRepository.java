package com.Avub.api.Customer.status.GetData.repository;

import com.Avub.api.Customer.status.GetData.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface LoginUserRepository extends JpaRepository<User, String>{
    User findPasswordByMobileNumber(String mobileNo);
    }


