package com.Avub.api.Customer.status.GetData.Rabib;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="customer_information")
public class CusModel {



    @jakarta.persistence.Id
    @Column(name="MOBILE_NO")
    private String mobileNumber;
    @Column(name="CUS_PWD")
    private String password;


    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber != null ? mobileNumber.trim() : null;
    }
}

