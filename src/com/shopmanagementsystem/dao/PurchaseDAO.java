/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.Purchase;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface PurchaseDAO {
    
    public Integer add(Purchase purchase);
    
    public Integer update(Purchase purchase);
    
    public Integer delete(Integer purchaseID);
    
    public List<Purchase> getAll();
}
