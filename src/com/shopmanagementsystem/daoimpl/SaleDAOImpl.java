/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.SaleDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Customer;
import com.shopmanagementsystem.model.Sale;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public class SaleDAOImpl implements SaleDAO
{
    Connection con ;
    
    public SaleDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }

    @Override
    public Integer add(Sale sale) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into sale (customer_id, purchase_date, grand_total, sale_code) values (?, ?, ?, ?)");
            
            preparedStatement.setInt(1, sale.getCustomer().getId());
            
            Date purchaseDate = Date.valueOf(sale.getPurchaseDate());
            preparedStatement.setDate(2, purchaseDate);
            
            preparedStatement.setDouble(3, sale.getGrandTotal());
            
            preparedStatement.setString(4, sale.getSaleCode());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer update(Sale sale) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update sale set customer_id = ?, purchase_date = ?, grand_total = ?, sale_code = ? where id = ?");
            
            preparedStatement.setInt(1, sale.getCustomer().getId());
            
            // Convert LocalDate to java.sql.Date
            Date purchaseDate = Date.valueOf(sale.getPurchaseDate());
            preparedStatement.setDate(2, purchaseDate);
            
            preparedStatement.setDouble(3, sale.getGrandTotal());
            
            preparedStatement.setString(4, sale.getSaleCode());
            
            preparedStatement.setInt(5, sale.getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;

    }

    @Override
    public Integer delete(Integer saleID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from sale where id = ?");
          
            preparedStatement.setInt(1, saleID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<Sale> getAll() {
        
        List<Sale> allSale = new ArrayList();
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT s.id, s.purchase_date, s.grand_total, s.sale_code, c.id, c.name\n" +
"FROM sale s\n" +
"INNER JOIN customer c ON s.customer_id = c.id\n" +
"ORDER BY s.id;");
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                 //Convert from java.sql.Date to LocalDate. For that, we can use the toLocalDate() method:
                
                allSale.add(new Sale(rs.getInt(1), new Customer(rs.getInt(5), rs.getString(6)), rs.getDate(2).toLocalDate(), rs.getDouble(3), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return allSale;
    }
    
}
