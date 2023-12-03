/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPkg;

import java.io.Serializable;
import java.time.LocalDate;

public class Incident implements Serializable {
    private String employeeName;
    private String incidentName;
    private LocalDate date;
    private String description;

    public Incident(String employeeName, String incidentName, LocalDate date, String description) {
        this.employeeName = employeeName;
        this.incidentName = incidentName;
        this.date = date;
        this.description = description;
    }

    // Getters and setters for each field

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getIncidentName() {
        return incidentName;
    }

    public void setIncidentName(String incidentName) {
        this.incidentName = incidentName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

