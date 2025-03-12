package com.Avub.api.Customer.status.GetData.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerInformationRepository extends JpaRepository<CustomerInformation, Long> {
    Optional<CustomerInformation> findByMobileNo(String mobileNo);
}
