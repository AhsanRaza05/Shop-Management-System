/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.model;

/**
 *
 * @author Ahsan
 */
public class SaleDetails {
    
    Integer id;
    Integer quantity;
    
    // Product Object
    Products product;
     // TO DO : Convert it into BigDecimal After asking from sir.
    Double total;
    
    // Sale Object
    Sale sale;
    
    
}
