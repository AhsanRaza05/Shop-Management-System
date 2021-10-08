/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.Customer;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface CustomerDAO {
    
    public Integer add(Customer customer);
    
    public Integer update(Customer customer);
    
    public Integer delete(Integer customerID);
    
    public List<Customer> getAll();
}
