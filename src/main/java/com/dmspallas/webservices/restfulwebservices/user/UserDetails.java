package com.dmspallas.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"password"})
public class UserDetails {
    private String username;
    private String password;
    private String email;

    public UserDetails(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }


}
