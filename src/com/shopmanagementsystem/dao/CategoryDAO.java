/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.dao;

import com.shopmanagementsystem.model.Category;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface CategoryDAO {
    
    /**
     * This Method ADD or INSERT Category's data into Category table (A New Row).
     *
     * @Query Insert into category values(?,?)
     *
     * @param category OBJECT of Category CLASS Contains Category's ID, NAME
     *
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
     */
    public Integer add(Category category);
    
    public Integer update(Category category);
    
    public Integer delete(Integer categoryID);
    
    public List<Category> getAll();
}
