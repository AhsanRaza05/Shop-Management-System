/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.daoimpl;

import com.shopmanagementsystem.dao.CustomerDAO;
import com.shopmanagementsystem.dbconnection.DataBaseConnection;
import com.shopmanagementsystem.model.Customer;
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
public class CustomerDAOImpl implements CustomerDAO{

    Connection con;
    
    public CustomerDAOImpl(){
        con = DataBaseConnection.getDBConnection();
    }
    
    @Override
    public Integer add(Customer customer) {
        Integer result = 0;
        
        try {
            PreparedStatement pst = con.prepareStatement("insert into material(name) values(?)");
            
            pst.setString(1,customer.getName());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL Exception while adding Customer");
        }catch (Exception e) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception while adding Customer");
        }
        
        return result;
    }

    @Override
    public Integer update(Customer customer) {
        
        Integer result = 0;
        
        try {
            PreparedStatement pst = con.prepareStatement("update customer set name = ? where id = ?");
            
            pst.setString(1,customer.getName());
            pst.setInt(2, customer.getId());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL Exception while adding Customer");
        }catch (Exception e) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception while adding Customer");
        }
        
        return result;
    }

    @Override
    public Integer delete(Integer customerID) {
        
        Integer result = 0;
        
        try {
            PreparedStatement pst = con.prepareStatement("delete from customer where id = ?");
            
            pst.setInt(1, customerID);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL Exception while adding Customer");
        }catch (Exception e) {
            //Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception while adding Customer");
        }
        
        return result;
        
    }

    @Override
    public List<Customer> getAll() {
        
        List <Customer> customers = new ArrayList();
        
        try {
            PreparedStatement pst = con.prepareStatement("Select * from customer");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                customers.add(new Customer(rs.getInt("id"), rs.getString("name")));
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
