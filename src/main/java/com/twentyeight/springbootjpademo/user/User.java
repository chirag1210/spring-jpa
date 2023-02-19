package com.twentyeight.springbootjpademo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "User model description")
public class User {

    private int userId;

    @Size(min=2, message="Name should have atleast 2 characters")
    private String name;
    @Size(min=2, message="Ciy should have atleast 2 characters")
    private String city;

    public User(int userId, String name, String city) {
        this.userId = userId;
        this.name = name;
        this.city = city;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
