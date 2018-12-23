package com.example.dell.rentapp;

public class Account {
    private String Username;
    private String Password;
    private boolean Status;

    public Account() {
    }

    public Account(String username, String password, boolean status) {
        Username = username;
        Password = password;
        Status = status;
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
}
