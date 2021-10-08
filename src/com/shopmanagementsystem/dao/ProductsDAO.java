/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.Products;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface ProductsDAO {
    
    
    public Integer add(Products product);
    
    public Integer update(Products product);
    
    public Integer delete(Integer productID);
    
    public List<Products> getAll();
}
