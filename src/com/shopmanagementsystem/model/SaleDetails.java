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
    
    private Integer id;
    private Integer quantity;
    
    // Product Object
    private Products product;
    private Double total;
    // Sale Object
    private Sale sale;

    public SaleDetails(Integer id, Integer quantity, Products product, Double total, Sale sale) {
        this.id = id;
        this.quantity = quantity;
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Products Class
        this.product = new Products(product.getId(), product.getName(), product.getQuantity(), product.getSellingPrice(), product.getPurchase_price(), product.getCategory());
        this.total = total;
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Sale Class
        this.sale = new Sale(sale.getId(), sale.getCustomer(), sale.getPurchaseDate(), sale.getGrandTotal(), sale.getSaleCode());
    }

    public Sale getSale() {
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Sale Class
        return (new Sale(sale.getId(), sale.getCustomer(), sale.getPurchaseDate(), sale.getGrandTotal(), sale.getSaleCode()));
    }

    public void setSale(Sale sale) {
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Sale Class
        this.sale = new Sale(sale.getId(), sale.getCustomer(), sale.getPurchaseDate(), sale.getGrandTotal(), sale.getSaleCode());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProduct() {
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Products Class
        return (new Products(product.getId(), product.getName(), product.getQuantity(), product.getSellingPrice(), product.getPurchase_price(), product.getCategory()));
    }

    public void setProduct(Products product) {
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Products Class
        this.product = new Products(product.getId(), product.getName(), product.getQuantity(), product.getSellingPrice(), product.getPurchase_price(), product.getCategory());
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
