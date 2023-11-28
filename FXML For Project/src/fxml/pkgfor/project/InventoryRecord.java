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
public class InventoryRecord implements Serializable{
    private String name;
    private int unit;
    private double invVal;

    public InventoryRecord(String name, int unit, double invVal) {
        this.name = name;
        this.unit = unit;
        this.invVal = invVal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getInvVal() {
        return invVal;
    }

    public void setInvVal(double invVal) {
        this.invVal = invVal;
    }

    
    
    
    
}
