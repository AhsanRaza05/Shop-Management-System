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
public abstract class DataBaseCommonColumns {
 
    private LocalDate createdDate;
    private Integer createdByUserID;
    private LocalDate modifiedDate;
    private Integer modifiedByUserID;
    private Boolean status;

    public DataBaseCommonColumns(LocalDate createdDate, Integer createdByUserID, Boolean status) {
        this.createdDate = createdDate;
        this.createdByUserID = createdByUserID;
        this.status = status;
    }

    public DataBaseCommonColumns() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedByUserID() {
        return createdByUserID;
    }

    public void setCreatedByUserID(Integer createdByUserID) {
        this.createdByUserID = createdByUserID;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedByUserID() {
        return modifiedByUserID;
    }

    public void setModifiedByUserID(Integer modifiedByUserID) {
        this.modifiedByUserID = modifiedByUserID;
    }
    
}
