/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.PurchaseDetails;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface PurchaseDetailsDAO {
    
    public Integer add(PurchaseDetails purchaseDetail);
    
    public Integer update(PurchaseDetails purchaseDetail);
    
    public Integer delete(Integer purchaseDetailID);
    
    public List<PurchaseDetails> getAll();
}
