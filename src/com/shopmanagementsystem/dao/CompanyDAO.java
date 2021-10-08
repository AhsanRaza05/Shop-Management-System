/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.Company;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface CompanyDAO {
    
    public Integer add(Company company);
    
    public Integer update(Company company);
    
    public Integer delete(Integer companyID);
    
    public List<Company> getAll();
}
