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
public class Customer extends DataBaseCommonColumns{
    
    private Integer id;
    private String name;

    public Customer(Integer id, String name, LocalDate createdDate, Integer createdByUserID, Boolean status) {
        super(createdDate, createdByUserID, status);
        this.id = id;
        this.name = name;
    }

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
