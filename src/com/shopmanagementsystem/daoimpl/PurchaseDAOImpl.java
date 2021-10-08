/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.PurchaseDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Company;
import com.shopmanagementsystem.model.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public class PurchaseDAOImpl implements PurchaseDAO{

    Connection con;
    
    public PurchaseDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }
    @Override
    public Integer add(Purchase purchase) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into purchase (company_id ,purchase_date, grand_total, purchase_code) values (?, ?, ?, ?)");
            
            preparedStatement.setInt(1, purchase.getCompany().getId());
            
            Date purchaseDate = Date.valueOf(purchase.getPurchaseDate());
            preparedStatement.setDate(2, purchaseDate);
            
            preparedStatement.setDouble(3, purchase.getGrandTotal());
            
            preparedStatement.setString(4, purchase.getPurchaseCode());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer update(Purchase purchase) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update purchase set company_id = ?, purchase_date = ?, grand_total = ?, purchase_code = ? where id = ?");
            
            preparedStatement.setInt(1, purchase.getCompany().getId());
            
            // Convert LocalDate to java.sql.Date
            Date purchaseDate = Date.valueOf(purchase.getPurchaseDate());
            preparedStatement.setDate(2, purchaseDate);
            
            preparedStatement.setDouble(3, purchase.getGrandTotal());
            
            preparedStatement.setString(4, purchase.getPurchaseCode());
            
            preparedStatement.setInt(5, purchase.getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer delete(Integer purchaseID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from purchase where id = ?");
          
            preparedStatement.setInt(1, purchaseID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<Purchase> getAll() {
        
        List<Purchase> allPurchase = new ArrayList();
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT p.id, p.purchase_date, p.grand_total, p.purchase_code, c.id, c.name, c.location, c.contact, c.email\n" +
"FROM purchase p\n" +
"INNER JOIN company c ON p.company_id = c.id\n" +
"ORDER BY p.id");
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                 //Convert from java.sql.Date to LocalDate. For that, we can use the toLocalDate() method:
                
                allPurchase.add(new Purchase(rs.getInt(1), new Company(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)), rs.getDate(2).toLocalDate(), rs.getDouble(3), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return allPurchase;
    }
    
}
