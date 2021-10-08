/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.ProductsDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Category;
import com.shopmanagementsystem.model.Products;
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
public class ProductsDAOImpl implements ProductsDAO{

    Connection con;
    
    public ProductsDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }
    
    @Override
    public Integer add(Products product) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into category (name, quantity, selling_price, purchase_price, category_id) values (?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, product.getName());
            
            preparedStatement.setInt(2, product.getQuantity());
            
            preparedStatement.setDouble(3, product.getSellingPrice());
            
            preparedStatement.setDouble(4, product.getPurchase_price());
            
            preparedStatement.setInt(5, product.getCategory().getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer update(Products product) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update products set name = ?, quantity = ?, selling_price = ?, purchase_price = ?, category_id = ? where id = ? ");
            
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setDouble(3, product.getSellingPrice());
            preparedStatement.setDouble(4, product.getPurchase_price());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setInt(2, product.getId()); 
            
            result = preparedStatement.executeUpdate();  
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer delete(Integer productID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from products where id = ? ");
            
            preparedStatement.setInt(1, productID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<Products> getAll() {
        List <Products> customers = new ArrayList();
        
        try {
            PreparedStatement pst = con.prepareStatement("SELECT p.id, p.name, p.quantity, p.selling_price, p.purchase_price, c.id, c.name\n" +
"FROM products p\n" +
"INNER JOIN category c ON p.category_id = c.id ORDER BY p.id");
            
            ResultSet rs = pst.executeQuery();
            
            //rs.getT
            while(rs.next()){
                
                customers.add(new Products(rs.getInt("id"), rs.getString("name"), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), new Category(rs.getInt(5), null)));
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL Exception while getting All Customer");
        }catch (Exception e) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception while getting All Customer");
        }
        return customers;
    }
    
    
}
