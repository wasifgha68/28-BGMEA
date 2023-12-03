/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPkg;
import java.io.Serializable;
import java.time.LocalDate;

public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private String contact;
    private LocalDate dateOfJoining;

    public Supplier(String name, String id, String contact, LocalDate dateOfJoining) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters and setters for fields

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