package MainPkg;

import java.io.Serializable;
import java.time.LocalDate;

public class EymployeeDetails implements Serializable {
    private String employeeName;
    private String password;
    private String employeeID;
    private LocalDate dateOfJoining;
    private String employeeType;
    private String status;

    public EymployeeDetails(String employeeName, String password, String employeeID, LocalDate dateOfJoining, String employeeType, String status) {
        this.employeeName = employeeName;
        this.password = password;
        this.employeeID = employeeID;
        this.dateOfJoining = dateOfJoining;
        this.employeeType = employeeType;
        this.status = status;
    }

    // Getters and Setters for all fields...

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
