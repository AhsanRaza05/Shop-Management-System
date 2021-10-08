/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.model;
import java.time.*;
/**
 *
 * @author Ahsan
 */
public class Sale {
    
    private Integer id;
    
    private Customer customer;  
    private LocalDate purchaseDate;
    private Double grandTotal;
    private String saleCode;

    public Sale(Integer id, Customer customer, LocalDate purchaseDate, Double grandTotal, String saleCode) {
        
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.grandTotal = grandTotal;
        this.saleCode = saleCode;
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in customer Class.
        this.customer = new Customer(customer.getId(), customer.getName());
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        // TODO: Replace with deep Clone Way i.e. Override the clone() in customer Class.
        return (new Customer(customer.getId(), customer.getName()));
    }

    public void setCustomer(Customer customer) {
        // TODO: Replace with deep Clone Way i.e. Override the clone() in customer Class.
        this.customer = (new Customer(customer.getId(), customer.getName()));
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }
    
    
            
    
}
