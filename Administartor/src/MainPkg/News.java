package MainPkg;
import java.io.Serializable;
import java.time.LocalDate;

public class News implements Serializable {
    private String headline;
    private LocalDate date;
    private String status;
    private String Description;

    
    public News(String headline, LocalDate date, String status) 
    {
        this.headline = headline;
        this.date = date;
        this.status = status;
        
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}

