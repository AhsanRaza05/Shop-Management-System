/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.model;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Ahsan
 */
public class Sale extends DataBaseCommonColumns{
    
    private Integer id;
    
    private Customer customer;  
    private LocalDate purchaseDate;
    private Double grandTotal;
    private String saleCode;

    public Sale(Integer id, Customer customer, LocalDate purchaseDate, Double grandTotal, String saleCode, LocalDate createdDate, Integer createdByUserID, Boolean status) {
        super(createdDate, createdByUserID, status);
        this.id = id;
        this.customer = customer;
        this.purchaseDate = purchaseDate;
        this.grandTotal = grandTotal;
        this.saleCode = saleCode;
    }
    
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
        
         //String s = purchaseDate.format((DateTimeFormatter.ofPattern("dd-MM-yyyy")));
         //System.out.println(s);
         //return LocalDate.parse(s);
        //return (LocalDate.parse(purchaseDate.toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
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
