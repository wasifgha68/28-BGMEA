/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class CreateSampleOrder implements Serializable{
    private int catalogNum;
    private int quantity;
    private String itemName;

    public CreateSampleOrder(int catalogNum, int quantity, String itemName) {
        this.catalogNum = catalogNum;
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public int getCatalogNum() {
        return catalogNum;
    }

    public void setCatalogNum(int catalogNum) {
        this.catalogNum = catalogNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    
}
