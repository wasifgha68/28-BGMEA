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
public class UpdateProductionPlan implements Serializable{
    private String prodName;
    private String objective;
    private int employeeID;

    public UpdateProductionPlan(String prodName, String objective, int employeeID) {
        this.prodName = prodName;
        this.objective = objective;
        this.employeeID = employeeID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    
    
}
