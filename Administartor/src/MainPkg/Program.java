/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPkg;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Program implements Serializable  {
    private String employeeName;
    private LocalDate date;
    private String webinarName;
    private String description;
    private String Status;

   
    public Program(String employeeName, LocalDate date, String webinarName, String description,String Status) {
        this.employeeName = employeeName;
        this.date = date;
        this.webinarName = webinarName;
        this.description = description;
        this.Status=Status;
    }

    
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWebinarName() {
        return webinarName;
    }

    public void setWebinarName(String webinarName) {
        this.webinarName = webinarName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    

    
}
