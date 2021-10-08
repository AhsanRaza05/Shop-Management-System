/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.SaleDetails;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface SaleDetailsDAO {
    
    public Integer add(SaleDetails saleDetail);
    
    public Integer update(SaleDetails saleDetail);
    
    public Integer delete(SaleDetails saleDetail);
    
    public List<SaleDetails> getAll();
}
