/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopmanagementsystem.model;

import java.time.LocalDate;

/**
 *
 * @author Ahsan
 */
public class PurchaseDetails extends DataBaseCommonColumns{
    
    private Integer id;
    private Integer quantity;
    // Product Object
    private Products product;
    private Double total;
    // Purchase Object
    private Purchase purchase;

    public PurchaseDetails(Integer id, Integer quantity, Products product, Double total, Purchase purchase, LocalDate createdDate, Integer createdByUserID, Boolean status) {
        super(createdDate, createdByUserID, status);
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.total = total;
        this.purchase = purchase;
    }
    
    public PurchaseDetails(Integer id, Integer quantity, Products product, Double total, Purchase purchase) {
        this.id = id;
        this.quantity = quantity;
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Products Class
        this.product = new Products(product.getId(), product.getName(), product.getQuantity(), product.getSellingPrice(), product.getPurchase_price(), product.getCategory());
        this.total = total;
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Purchase Class
        this.purchase = new Purchase(purchase.getId(), purchase.getCompany(), purchase.getPurchaseDate(), purchase.getGrandTotal(), purchase.getPurchaseCode());
    }
    
    public Purchase getPurchase() {
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Purchase Class
        return (new Purchase(purchase.getId(), purchase.getCompany(), purchase.getPurchaseDate(), purchase.getGrandTotal(), purchase.getPurchaseCode()));
    }

    public void setPurchase(Purchase purchase) {
        // TODO: Replace with deep Clone Way i.e. Override the clone() in Purchase Class
        this.purchase = new Purchase(purchase.getId(), purchase.getCompany(), purchase.getPurchaseDate(), purchase.getGrandTotal(), purchase.getPurchaseCode());
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
