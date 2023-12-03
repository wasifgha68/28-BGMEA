package MainPkg;


import java.io.Serializable;
import java.time.LocalDate;

public class Event2 implements Serializable {
    

    private String name;
    private String employeeType;
    private String eventType;
    private String eventName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String Status;

    public Event2(String name, String employeeType, String eventType, String eventName, LocalDate startDate, LocalDate endDate, String description, String Status) {
        this.name = name;
        this.employeeType = employeeType;
        this.eventType = eventType;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description=description;
        this.Status=Status;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

