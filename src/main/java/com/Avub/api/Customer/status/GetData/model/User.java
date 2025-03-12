package com.Avub.api.Customer.status.GetData.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="CUSTOMER_INFORMATION")
public class User {
    @jakarta.persistence.Id
    @Column(name="MOBILE_NO")
    private String mobileNumber;
    @Column(name="CUS_PWD")
    private String password;







    public User() {
    }

    public User(String mobileNumber, String password) {
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    @PrePersist
    @PreUpdate
    private void trimMobileNumber() {
        if (this.mobileNumber != null) {
            this.mobileNumber = this.mobileNumber.trim();
        }
    }
}
