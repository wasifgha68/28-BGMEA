package MainPkg;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class AccountManagementTB {
    private String name;
    private String employeeID;
    private String typeOfEmployee;
    private LocalDate  dateOfJoining;
    private String status;

    public AccountManagementTB(String name, String employeeID, String typeOfEmployee, LocalDate dateOfJoining, String status) {
        this.name = name;
        this.employeeID = employeeID;
        this.typeOfEmployee = typeOfEmployee;
        this.dateOfJoining = dateOfJoining;
        this.status = status;
    }

    // Getters for each field
    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getStatus() {
        return status;
    }
}
