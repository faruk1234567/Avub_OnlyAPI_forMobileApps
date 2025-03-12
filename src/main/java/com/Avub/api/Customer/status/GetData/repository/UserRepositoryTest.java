package com.Avub.api.Customer.status.GetData.repository;

import com.Avub.api.Customer.status.GetData.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryTest extends JpaRepository<User, String> {
    Optional<User> findByMobileNumber(String mobileNumber);
}
