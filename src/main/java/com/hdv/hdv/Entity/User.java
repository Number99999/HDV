package com.hdv.hdv.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;


    @Column(name = "image")
    private String img;

    private String phone;

    private String address;

    @Email
    private String email;
    private boolean admin;

    public User() {
    }

    public User(String username, String password, String phone, String add, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = add;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return address;
    }

    public void setAdd(String add) {
        this.address = add;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
