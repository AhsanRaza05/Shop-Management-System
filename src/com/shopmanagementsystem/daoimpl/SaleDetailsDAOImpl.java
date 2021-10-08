/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.SaleDAO;
import com.shopmanagementsystem.dao.SaleDetailsDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Category;
import com.shopmanagementsystem.model.Customer;
import com.shopmanagementsystem.model.Products;
import com.shopmanagementsystem.model.PurchaseDetails;
import com.shopmanagementsystem.model.Sale;
import com.shopmanagementsystem.model.SaleDetails;
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
public class SaleDetailsDAOImpl implements SaleDetailsDAO{

    Connection con;
    
    public SaleDetailsDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }
    @Override
    public Integer add(SaleDetails saleDetail) {
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into sale_details (product_id ,quantity, total, sale_id) values (?, ?, ?, ?)");
            
            preparedStatement.setInt(1, saleDetail.getProduct().getId());
            
            preparedStatement.setInt(2, saleDetail.getQuantity());
            
            preparedStatement.setDouble(3, saleDetail.getTotal());
            
            preparedStatement.setInt(4, saleDetail.getSale().getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
        
    }

    @Override
    public Integer update(SaleDetails saleDetail) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update sale_details set product_id = ?, quantity = ?, total = ?, sale_id = ? where id = ?");
            
            preparedStatement.setInt(1, saleDetail.getProduct().getId());
            
            preparedStatement.setInt(2, saleDetail.getQuantity());
            
            preparedStatement.setDouble(3, saleDetail.getTotal());
            
            preparedStatement.setInt(4, saleDetail.getSale().getId());
            
            preparedStatement.setInt(5, saleDetail.getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer delete(Integer saleDetailID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from sale_details where id = ?");
          
            preparedStatement.setInt(1, saleDetailID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<SaleDetails> getAll() {
        
        List<SaleDetails> allPurchaseDetails = new ArrayList();
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT sd.id, pr.id, pr.name, pr.quantity, pr.selling_price, pr.purchase_price, ca.id, ca.name, sd.quantity, sd.total, sd.sale_id, co.id, co.name, sa.purchase_date, sa.grand_total, sa.sale_code \n" +
"FROM sale_details sd\n" +
"INNER JOIN products pr ON sd.product_id = pr.id\n" +
"INNER JOIN category ca ON pr.category_id = ca.id\n" +
"INNER JOIN sale sa ON sd.sale_id = sa.id\n" +
"INNER JOIN customer co ON sa.customer_id = co.id");
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                Category category = new Category(rs.getInt(7), rs.getString(8));
                
                Products product = new Products(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), category); 
                
                Customer customer = new Customer(rs.getInt(12), rs.getString(13));
                
                Sale sale = new Sale(rs.getInt(11), customer, rs.getDate(14).toLocalDate(), rs.getDouble(15), rs.getString(16));
                
                allPurchaseDetails.add( new SaleDetails(rs.getInt(1), rs.getInt(9), product, rs.getDouble(10), sale));
                
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in SaleDetails DAO!");
        }       
        
        return allPurchaseDetails;
    }
    
    
    
}
