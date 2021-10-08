/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.Sale;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface SaleDAO {
    
    public Integer add(Sale sale);
    
    public Integer update(Sale sale);
    
    public Integer delete(Integer saleID);
    
    public List<Sale> getAll();
}
