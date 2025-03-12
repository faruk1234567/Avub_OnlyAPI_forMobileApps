package com.Avub.api.Customer.status.GetData.model;


import java.math.BigDecimal;

public class Customer {
    private String mobile_no;

    private String CUSTOMER_NAME;


    public Customer() {
    }

    public Customer(String mobile_no, String CUSTOMER_NAME) {
        this.mobile_no = mobile_no;
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "mobile_no='" + mobile_no + '\'' +
                ", CUSTOMER_NAME='" + CUSTOMER_NAME + '\'' +
                '}';
    }
}
