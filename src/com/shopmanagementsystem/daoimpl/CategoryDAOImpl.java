/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.CategoryDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahsan
 */
public class CategoryDAOImpl implements CategoryDAO {

    Connection con;
    
    public CategoryDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }
    
    @Override
    public Integer add(Category category) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into category (name) values (?)");
            
            preparedStatement.setString(1, category.getName());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer update(Category category) {
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update category set name = ? where id = ? ");
            
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2, category.getId());
            
            result = preparedStatement.executeUpdate();  
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer delete(Integer categoryID) {
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from category where id = ? ");
            
            preparedStatement.setInt(1, categoryID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<Category> getAll() {
        
        List <Category> allCategories = new ArrayList(0);
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from category");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            allCategories = new ArrayList();
            
            while(resultSet.next()){
                
                allCategories.add(new Category(resultSet.getInt(1), resultSet.getString(2)));
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return allCategories;
    }
    
}