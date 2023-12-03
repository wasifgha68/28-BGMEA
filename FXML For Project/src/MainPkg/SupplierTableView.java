/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPkg;

/**
 *
 * @author Hp
 */

import java.io.Serializable;
import java.time.LocalDate;

public class SupplierTableView implements Serializable {
    

    private String name;
    private String id;
    private String contact;
    private LocalDate dateOfJoining;

    public SupplierTableView (String name, String id, String contact, LocalDate dateOfJoining) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.dateOfJoining = dateOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

   
}
    
