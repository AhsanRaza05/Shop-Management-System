/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.PurchaseDetailsDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Category;
import com.shopmanagementsystem.model.Company;
import com.shopmanagementsystem.model.Products;
import com.shopmanagementsystem.model.Purchase;
import com.shopmanagementsystem.model.PurchaseDetails;
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
public class PurchaseDetailsDAOImpl implements PurchaseDetailsDAO{

    Connection con;
    
    public PurchaseDetailsDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }
    
    @Override
    public Integer add(PurchaseDetails purchaseDetail) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into purchase_details (product_id ,quantity, total, purchase_id) values (?, ?, ?, ?)");
            
            preparedStatement.setInt(1, purchaseDetail.getProduct().getId());
            
            preparedStatement.setInt(2, purchaseDetail.getQuantity());
            
            preparedStatement.setDouble(3, purchaseDetail.getTotal());
            
            preparedStatement.setInt(4, purchaseDetail.getPurchase().getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
        
    }

    @Override
    public Integer update(PurchaseDetails purchaseDetail) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update purchase_details set product_id = ?, quantity = ?, total = ?, purchase_id = ? where id = ?");
            
            preparedStatement.setInt(1, purchaseDetail.getProduct().getId());
            
            preparedStatement.setInt(2, purchaseDetail.getQuantity());
            
            preparedStatement.setDouble(3, purchaseDetail.getTotal());
            
            preparedStatement.setInt(4, purchaseDetail.getPurchase().getId());
            
            preparedStatement.setInt(5, purchaseDetail.getId());
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public Integer delete(Integer PurchaseDetailID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from purchase_details where id = ?");
          
            preparedStatement.setInt(1, PurchaseDetailID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return result;
    }

    @Override
    public List<PurchaseDetails> getAll() {
        List<PurchaseDetails> allPurchaseDetails = new ArrayList();
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT pd.id, pr.id, pr.name, pr.quantity, pr.selling_price, pr.purchase_price, ca.id, ca.name, pd.quantity, pd.total, pd.purchase_id, co.id, co.name, co.location, co.contact, co.email, pu.purchase_date, pu.grand_total, pu.purchase_code \n" +
"FROM purchase_details pd\n" +
"INNER JOIN products pr ON pd.product_id = pr.id\n" +
"INNER JOIN category ca ON pr.category_id = ca.id\n" +
"INNER JOIN purchase pu ON pd.purchase_id = pu.id\n" +
"INNER JOIN company co ON pu.company_id = co.id");
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                Category category = new Category(rs.getInt(7), rs.getString(8));
                
                Products product = new Products(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), category); 
                
                Company company = new Company(rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
                
                Purchase purchase = new Purchase(rs.getInt(11), company, rs.getDate(17).toLocalDate(), rs.getDouble(18), rs.getString(19));
                
                allPurchaseDetails.add( new PurchaseDetails(rs.getInt(1), rs.getInt(9), product, rs.getDouble(10), purchase));
                
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
        }       
        
        return allPurchaseDetails;
    }
    
}
