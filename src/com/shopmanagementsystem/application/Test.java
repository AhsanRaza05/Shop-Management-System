/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.application;

import com.shopmanagementsystem.dao.CategoryDAO;
import com.shopmanagementsystem.daoimpl.CategoryDAOImpl;
import com.shopmanagementsystem.daoimpl.SaleDetailsDAOImpl;
import com.shopmanagementsystem.dao.SaleDetailsDAO;
import com.shopmanagementsystem.model.SaleDetails;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ahsan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //CategoryDAO c = new CategoryDAOImpl();
        //c.add();
        
        SaleDetailsDAO saledetails = new SaleDetailsDAOImpl();
        
        for(SaleDetails s : saledetails.getAll()){
            
            System.out.println(s.getId());
            System.out.println(s.getQuantity());
            System.out.println(s.getTotal());
            System.out.println(s.getProduct().getName());
            System.out.println(s.getProduct().getPurchase_price());
            System.out.println(s.getProduct().getSellingPrice());
            System.out.println(s.getProduct().getCategory().getName());
            System.out.println(s.getSale().getPurchaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println(s.getSale().getGrandTotal());
            System.out.println(s.getSale().getSaleCode());
            System.out.println(s.getSale().getCustomer().getName());
            
            System.out.println("\n");
            
        }
    }
    
}
