package MainPkg;
import java.io.Serializable;
import java.time.LocalDate;

public class Vendor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private String contact;
    private LocalDate dateOfJoining;

    // Constructors
    public Vendor() {
        // Default constructor
    }

    public Vendor(String name, String id, String contact, LocalDate dateOfJoining) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters and Setters
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