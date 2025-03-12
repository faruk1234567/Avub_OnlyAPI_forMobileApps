package com.Avub.api.Customer.status.GetData.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@Getter
@Entity
@Table(name = "CUSTOMER_INFORMATION")
public class CustomerInformation {
    @jakarta.persistence.Id
   // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "MOBILE_NO")
    private String mobileNo;
   // private String MOBILE_NO;


    @Column(name = "cus_pwd")
    private String cusPassword;

}
