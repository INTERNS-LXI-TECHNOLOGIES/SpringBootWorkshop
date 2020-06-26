package com.lxisoft.MockExam.web.dto;

public class UserRegistrationDto {

    private String name;
    private String password;

    public UserRegistrationDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserRegistrationDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
