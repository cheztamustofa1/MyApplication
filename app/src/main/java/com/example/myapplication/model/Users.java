package com.example.myapplication.model;

public class Users {
    public String email,password,retype ;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
        this.retype = retype;
    }

    public Users() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
