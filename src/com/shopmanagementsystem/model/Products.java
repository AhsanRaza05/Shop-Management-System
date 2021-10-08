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
public class Products {
    
    private Integer id;
    private String name;
    private Integer quantity;
    private Double sellingPrice;
    private Double purchase_price;
    // Category Object
    private Category category;

    public Products(Integer id, String name, Integer quantity, Double sellingPrice, Double purchase_price, Category category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.purchase_price = purchase_price;
        this.category = new Category(category.getId(), category.getName());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Category getCategory() {
        
        Category cat = new Category(category.getId(), category.getName());
        return cat;
    }

    public void setCategory(Category category) {
        this.category = new Category(category.getId(), category.getName());
    }
}
