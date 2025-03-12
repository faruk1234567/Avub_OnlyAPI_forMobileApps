package com.Avub.api.Customer.status.GetData.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
   /* @Repository
    public interface CustomerRepository extends CrudRepository<CustomerInformation, String> {

       *//* @Query("SELECT DISTINCT c.mobileNumber, c.password FROM User c WHERE c.mobileNumber = :mobileNumber")
        List<Object[]> findDistinctByMobileNo(String mobileNo);*//*

    }*/
   @Modifying
   @Transactional
   @Query("UPDATE User c SET c.password = :password WHERE TRIM(c.mobileNumber) = :mobileNo")
   void updatePasswordByMobileNo(@Param("mobileNo") String mobileNo, @Param("password") String password);
   @Query("SELECT u.password FROM User u WHERE u.mobileNumber = :mobileNumber")
   String findPasswordByMobileNo(String mobileNumber);
  // User findByMobileNumber(String mobileNo);
   /*User findByUsername(String username);*/
}
