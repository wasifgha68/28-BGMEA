package fxml.pkgfor.project;

import java.io.Serializable;


public class UpdateComplianceStatus implements Serializable{
    private String item;
    private String status;
    private String remarks;

    public UpdateComplianceStatus(String item, String status, String remarks) {
        this.item = item;
        this.status = status;
        this.remarks = remarks;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
}
