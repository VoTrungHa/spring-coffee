package com.coffee.coffee.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank(message = "userName is required")
    private String username;

    @NotNull(message = "Gender is required")
    private int gender;

    @NotBlank(message = "Phone is required")
    private String phone;


    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "passWord is required")
    private String password;

    @NotBlank(message = "Role is required")
    private String role;


    private String code;

    public User(){}
    public User(String username, int gender, String phone, String email, String password, String role) {
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
