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
public class ReviseSchedule implements Serializable{
    private int employeeID;
    private String shiftTimes;
    private String tasks;

    public ReviseSchedule(int employeeID, String shiftTimes, String tasks) {
        this.employeeID = employeeID;
        this.shiftTimes = shiftTimes;
        this.tasks = tasks;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getShiftTimes() {
        return shiftTimes;
    }

    public void setShiftTimes(String shiftTimes) {
        this.shiftTimes = shiftTimes;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
    
    
    
}
