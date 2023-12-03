package MainPkg;
import java.time.LocalDate;

public class EventTableView {
    private String employeeName;
    private String employeeType;
    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public EventTableView(String employeeName,String employeeType, String eventName, LocalDate startDate, LocalDate endDate, String status) {
        this.employeeName = employeeName;
        this.employeeType=employeeType;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeType() 
    {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) 
    {
        this.employeeType = employeeType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}