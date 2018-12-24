package com.example.dell.rentapp;

public class Account {
    private String Username;
    private String Password;
    private boolean Status;
    private String Name;
    private String Phone;
    private String Address;

    public Account() {
    }

    public Account(String username, String password, boolean status, String name, String phone, String address) {
        Username = username;
        Password = password;
        Status = status;
        Name = name;
        Phone = phone;
        Address = address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
