/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class FactoryManagerDatacBackupController implements Initializable 
{

    @FXML
    private ComboBox<String> FactoryManagerDataComboBox;
    @FXML
    private TextArea FactoryManagerTextArea;

    private final  vendorFileHandler vedorHandler = new  vendorFileHandler();
    private final  SupplierFileHandler supplierHandler = new  SupplierFileHandler();
    private  incidentFileHandler fileHandler = new incidentFileHandler(); 
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        FactoryManagerDataComboBox.getItems().addAll("Supplier Profile", "Vendor Profile","Incident Report","Request Webinar");
    }    

    @FXML
    private void ConfirmOnClick(ActionEvent event) 
    {
        String selectedDataType =FactoryManagerDataComboBox .getValue();

        if (selectedDataType != null) {
        if (selectedDataType.equals("Supplier Profile")) 
        {
            SupplierFileHandler supplierFileHandler = new SupplierFileHandler(); 
            ArrayList<SupplierTableView> suppliers = supplierFileHandler.loadSupplierListFromFile("supplierDetails.bin");
            displaySupplierData(suppliers);
        } 
        else if (selectedDataType.equals("Vendor Profile")) 
        {
            vendorFileHandler vendorFileHandler = new vendorFileHandler();
            ArrayList<Vendor> vendors = vendorFileHandler.loadVendorListFromFile("VendorDetails.bin");
            displayVendorData(vendors);
        }
        else if (selectedDataType.equals("Incident Report")) 
        {
            incidentFileHandler incidentFileHandler = new incidentFileHandler();
            ArrayList<Incident> Incident = incidentFileHandler.loadIncidentListFromFile("IncidentDetails.bin");
            displayIncidentData(Incident);
        }
        else if (selectedDataType.equals("Request Webinar")) 
        {
            ProgramFileHandler ProgramFileHandler = new ProgramFileHandler();
            ArrayList<Program> Program = ProgramFileHandler.loadProgramListFromFile("ProgramDetails.bin");
            displayProgramData(Program);
        }
        }
    }
    private void displayVendorData(ArrayList<Vendor>vendors) 
    {
        if (vendors != null && !vendors.isEmpty()) 
        {
            StringBuilder display = generateVendorInfo(vendors);
            FactoryManagerTextArea.setText(display.toString());
        }
        else 
        {
            FactoryManagerTextArea.setText("No vendor data found.");
        }
    }

    private void displaySupplierData(ArrayList<SupplierTableView> suppliers) 
    {
        if (suppliers != null && !suppliers.isEmpty()) 
        {
            StringBuilder display = generateSupplierInfo(suppliers);
            FactoryManagerTextArea.setText(display.toString());
        } 
        else 
        {
            FactoryManagerTextArea.setText("No supplier data found.");
        }
    }
    
    private StringBuilder generateSupplierInfo(ArrayList<SupplierTableView> suppliers) 
    {
        StringBuilder display = new StringBuilder();
        for (SupplierTableView supplier : suppliers) 
        {
            display.append("Name: ").append(supplier.getName()).append("\n")
               .append("ID: ").append(supplier.getId()).append("\n")
               .append("Contact: ").append(supplier.getContact()).append("\n")
               .append("Date of Joining: ").append(supplier.getDateOfJoining()).append("\n")
               .append("......").append("\n");
        }
        return display;
    }
    private StringBuilder generateVendorInfo(ArrayList<Vendor> vendors) 
    {
        StringBuilder display = new StringBuilder();
        for (Vendor vendor : vendors) 
        {
            display.append("Name: ").append(vendor.getName()).append("\n")
               .append("ID: ").append(vendor.getId()).append("\n")
               .append("Contact: ").append(vendor.getContact()).append("\n")
               .append("Date of Joining: ").append(vendor.getDateOfJoining()).append("\n")
               .append("......").append("\n");
        }
        return display;
    }
    private void displayIncidentData(ArrayList<Incident> incidents) 
    {
        if (incidents != null && !incidents.isEmpty()) 
        {
            StringBuilder display = generateIncidentInfo(incidents);
            FactoryManagerTextArea.setText(display.toString());
        } 
        else 
        {
            FactoryManagerTextArea.setText("No incident data found.");
        }
    }
    private StringBuilder generateIncidentInfo(ArrayList<Incident> incidents) 
    {
        StringBuilder display = new StringBuilder();
        for (Incident incident : incidents) 
        {
            display.append("Incident Name: ").append(incident.getIncidentName()).append("\n")
               .append("Date: ").append(incident.getDate()).append("\n")
               .append("Employee Involved: ").append(incident.getEmployeeName()).append("\n")
               .append("Description: ").append(incident.getDescription()).append("\n")
               .append("......").append("\n");
        }
        return display;
    } 
    private void displayProgramData(ArrayList<Program> Program) 
    {
        if (Program != null && !Program.isEmpty()) 
        {
            StringBuilder display = generateProgramInfo(Program);
            FactoryManagerTextArea.setText(display.toString());
        } 
        else 
        {
            FactoryManagerTextArea.setText("No program data found.");
        }
    }
    private StringBuilder generateProgramInfo(ArrayList<Program> programs) 
    {
        StringBuilder display = new StringBuilder();
        for (Program program : programs) 
        {
            display.append("Webinar Name: ").append(program.getWebinarName()).append("\n")
               .append("Date: ").append(program.getDate()).append("\n")
               .append("Employee Name: ").append(program.getEmployeeName()).append("\n")
               .append("Description: ").append(program.getDescription()).append("\n")
               .append("Status: ").append(program.getStatus()).append("\n")
               .append("......").append("\n");
        }
        return display;
    }
}
