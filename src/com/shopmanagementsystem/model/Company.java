/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.model;

import java.time.LocalDate;

/**
 *
 * @author Ahsan
 */
public class Company extends DataBaseCommonColumns{
 
    private Integer id;
    private String name;
    private String location;
    private String contact;
    private String email;

    public Company(Integer id, String name, String location, String contact, String email, LocalDate createdDate, Integer createdByUserID, Boolean status) {
        super(createdDate, createdByUserID, status);
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.email = email;
    }

    public Company(Integer id, String name, String location, String contact, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
}