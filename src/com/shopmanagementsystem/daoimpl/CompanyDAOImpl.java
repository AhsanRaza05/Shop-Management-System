/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.CompanyDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Category;
import com.shopmanagementsystem.model.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public class CompanyDAOImpl implements CompanyDAO{

    Connection con;
    
    public CompanyDAOImpl(){
    
        con = DataBaseConnection.getDBConnection();
    }
    
    @Override
    public Integer add(Company company) {
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into company (name, location, contact, email) values (?, ?, ?, ?)");
            
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2,company.getLocation());
            preparedStatement.setString(3,company.getContact());
            preparedStatement.setString(4,company.getEmail());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer update(Company company) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update company set name = ?, location = ?, contact = ?, email = ?  where id = ?");
            
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2,company.getLocation());
            preparedStatement.setString(3,company.getContact());
            preparedStatement.setString(4,company.getEmail());
            preparedStatement.setString(5,company.getEmail());
            preparedStatement.setInt(6,company.getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer delete(Integer companyID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from company where id = ?");
            
            preparedStatement.setInt(1,companyID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<Company> getAll() {
        
        List <Company> allCategories = new ArrayList();
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from company");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                allCategories.add(new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return allCategories;
    }
    
    
}
