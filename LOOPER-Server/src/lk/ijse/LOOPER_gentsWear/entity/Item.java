/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author sandun
 */
@Entity
public class Item {
    @Id
    private String iCode;
    private String categoryName;
    private String description;
    private String brand;
    private double sellingPrice;
    private int qty;

    public Item() {
    }

    public Item(String iCode, String categoryName, String description, String brand, double sellingPrice, int qty) {
        this.iCode = iCode;
        this.categoryName = categoryName;
        this.description = description;
        this.brand = brand;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public Item(String iCode, String description, double sellingPrice, int qty) {
        this.iCode = iCode;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public Item(String iCode, String description,int qty) {
        this.iCode = iCode;
        this.description = description;
        this.qty = qty;
    }

    public Item(String iCode, String description) {
        this.iCode = iCode;
        this.description = description;
    }
    
    
    
    

    /**
     * @return the iCode
     */
    public String getiCode() {
        return iCode;
    }

    /**
     * @param iCode the iCode to set
     */
    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }



    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" + "iCode=" + iCode + ", categoryName=" + categoryName + ", description=" + description + ", brand=" + brand + ", sellingPrice=" + sellingPrice + ", qty=" + qty + '}';
    }

    
    
    
}
