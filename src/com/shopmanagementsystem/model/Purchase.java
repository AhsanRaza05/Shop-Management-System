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
public class Purchase extends DataBaseCommonColumns{
    
    private Integer id;
    private LocalDate purchaseDate;
    private Double grandTotal;
    private String purchaseCode;
    private Company company;

    public Purchase(Integer id, LocalDate purchaseDate, Double grandTotal, String purchaseCode, Company company, LocalDate createdDate, Integer createdByUserID, Boolean status) {
        super(createdDate, createdByUserID, status);
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.grandTotal = grandTotal;
        this.purchaseCode = purchaseCode;
        this.company = company;
    }
    
    public Purchase(Integer id, Company company, LocalDate purchaseDate, Double grandTotal, String purchaseCode) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.grandTotal = grandTotal;
        this.purchaseCode = purchaseCode;
        //new Company()
        // TODO: Replace with deep Clone Way i.e. Override the clone() in company Class
        this.company = new Company(company.getId(), company.getName(), company.getLocation(), company.getContact(), company.getEmail());
    }

    public Company getCompany() {
        
        // TODO: Replace with deep Clone Way i.e. Override the clone() in company Class
        return (new Company(company.getId(), company.getName(), company.getLocation(), company.getContact(), company.getEmail()));
    }

    public void setCompany(Company company) {
         // TODO: Replace with deep Clone Way i.e. Override the clone() in company Class
        this.company = (new Company(company.getId(), company.getName(), company.getLocation(), company.getContact(), company.getEmail()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }
    
    
}
