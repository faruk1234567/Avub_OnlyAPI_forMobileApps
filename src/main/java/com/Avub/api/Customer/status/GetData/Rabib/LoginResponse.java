package com.Avub.api.Customer.status.GetData.Rabib;

public class LoginResponse {
    private String token;
    private String mobileNumber;
    //private String password;

    public LoginResponse(String token, String mobileNumber) {
        this.token = token;
        this.mobileNumber = mobileNumber;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


}
