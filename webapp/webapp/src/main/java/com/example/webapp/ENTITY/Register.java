package com.example.webapp.ENTITY;

import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RegisterTable")
public class Register{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long Rid;
@Column(name="Username",nullable = false)
private String Username;
@Column(name="Email",nullable = false)
private String Email;

@Column(name="Password",nullable = false)
private String Password;

public Register() {
}

public Register(String username, String email, String password) {
    Username = username;
    Email = email;
    Password = password;
}

public Long getRid() {
    return Rid;
}

public void setRid(Long rid) {
    Rid = rid;
}

public String getYourname() {
    return Username;
}

public void setYourname(String username) {
    Username = username;
}

public String getEmail() {
    return Email;
}

public void setEmail(String email) {
    Email = email;
}

public String getPassword() {
    return Password;
}

public void setPassword(String password) {
    Password = password;
}









}