/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class VendorController implements Initializable {

    @FXML
    private TextField VendorNameTextField;
    @FXML
    private TextField VendorIDTextField;
    @FXML
    private TextField VendorContactTextField;
    @FXML
    private DatePicker VendorDatePicker;
    @FXML
    private RadioButton AddNewVendorRB;
    @FXML
    private RadioButton ModifyVendorDetailsRB;
    @FXML
    private RadioButton CancelVendorDetailsRB;
    @FXML
    private TableView<Vendor> VendorTableView;
    @FXML
    private TableColumn<Vendor, String> VendorNameColTB;
    @FXML
    private TableColumn<Vendor, String> VendorIDColTB;
    @FXML
    private TableColumn<Vendor, String> VendorContactColTB;
    @FXML
    private TableColumn<Vendor, LocalDate> VendorDOJTB;
    
    private ObservableList<Vendor>VendorList = FXCollections.observableArrayList();
    private ToggleGroup toggleGroup;
    
    private vendorFileHandler fileHandler = new vendorFileHandler();
    private String filePath = "VendorDetails.bin";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        toggleGroup = new ToggleGroup();
        AddNewVendorRB.setToggleGroup(toggleGroup);
        ModifyVendorDetailsRB.setToggleGroup(toggleGroup);
        CancelVendorDetailsRB.setToggleGroup(toggleGroup);
        
        VendorNameColTB.setCellValueFactory(new PropertyValueFactory<>("name"));
        VendorIDColTB.setCellValueFactory(new PropertyValueFactory<>("id"));
        VendorContactColTB.setCellValueFactory(new PropertyValueFactory<>("contact"));
        VendorDOJTB.setCellValueFactory(new PropertyValueFactory<>("dateOfJoining"));
        
        loadVendorDataFromFile();
        VendorTableView.setItems(VendorList);
    }    

    @FXML private void GenerateVendorDetailsOnClick(ActionEvent event) 
    {
        loadVendorDataFromFile();
        if (AddNewVendorRB.isSelected()) 
        {
            handleAddNewVendor();
        } 
        else if (ModifyVendorDetailsRB.isSelected()) 
        {
            handleModifyVendor();
        } 
        else if (CancelVendorDetailsRB.isSelected()) 
        {
            handleCancelVendor();
        }
        
    }
    private void handleAddNewVendor() {
        String name = VendorNameTextField.getText();
        String id = VendorIDTextField.getText();
        String contact = VendorContactTextField.getText();
        LocalDate dateOfJoining = VendorDatePicker.getValue();

        if (name.isEmpty() || id.isEmpty() || contact.isEmpty() || dateOfJoining == null) 
        {
            showIncompleteDetailsAlert();
            return;
        }

        if (vendorExists(name, id)) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Vendor Already Exists");
            alert.setContentText("A vendor with the same Name or ID already exists.");
            alert.showAndWait();
            return;
        }

        Vendor newVendor = new Vendor(name, id, contact, dateOfJoining);
        VendorList.add(newVendor);
        clearInputFields();
        saveVendorDataToFile();
    }

    private void handleModifyVendor() {
        String name = VendorNameTextField.getText();
        String id = VendorIDTextField.getText();
        String contact = VendorContactTextField.getText();
        LocalDate dateOfJoining = VendorDatePicker.getValue();

        if (name.isEmpty() || id.isEmpty() || contact.isEmpty() || dateOfJoining == null) 
        {
            showIncompleteDetailsAlert();
            return;
        }

        boolean found = false;
        for (Vendor vendor : VendorList) 
        {
            if (vendor.getName().equalsIgnoreCase(name) && vendor.getId().equalsIgnoreCase(id)) 
            {
                vendor.setName(name);
                vendor.setId(id);
                vendor.setContact(contact);
                vendor.setDateOfJoining(dateOfJoining);
                found = true;
                break;
            }
        }
        
        if (!found) 
        {
            if (!found) 
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Vendor Not Found");
                alert.setContentText("The vendor details you're trying to modify/delete do not exist.");
                alert.showAndWait();
                return; 
            }
            return;
        }

        clearInputFields();
        saveVendorDataToFile();
    }

    private void handleCancelVendor() 
    {
        String name = VendorNameTextField.getText();
        String id = VendorIDTextField.getText();
        String contact = VendorContactTextField.getText();
        LocalDate dateOfJoining = VendorDatePicker.getValue();
        if (name.isEmpty() || id.isEmpty() || contact.isEmpty() || dateOfJoining == null) 
        {
            showIncompleteDetailsAlert();
            return;
        }

        boolean found = false;
        for (Vendor vendor : VendorList) 
        {
            if (vendor.getName().equalsIgnoreCase(name) && vendor.getId().equalsIgnoreCase(id)) 
            {
                VendorList.remove(vendor);
                found = true;
                break;
            }
        }
        
        if (!found) {Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Vendor Not Found");
        alert.setContentText("The vendor details you're trying to modify/delete do not exist.");
        alert.showAndWait();
        return; 
        }

        clearInputFields();
        saveVendorDataToFile();
    }

    private boolean vendorExists(String name, String ID) {
        for (Vendor vendor : VendorList) {
            if (vendor.getName().equalsIgnoreCase(name) || vendor.getId().equalsIgnoreCase(ID)) {
                return true; 
            }
        }
        return false;
    }

    private void showIncompleteDetailsAlert() 
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incomplete Details");
        alert.setContentText("Please fill in all fields.");
        alert.showAndWait();
        
    }

    private void clearInputFields() 
    {
        VendorNameTextField.clear();
        VendorIDTextField.clear();
        VendorContactTextField.clear();
        VendorDatePicker.setValue(null); 
               
    }

    @FXML
    private void ViewVendorDetailsOnClick(ActionEvent event) 
    {
        loadVendorDataFromFile();
        VendorTableView.setItems(VendorList);
        
    }

    
    private void saveVendorDataToFile() 
    {
        fileHandler.saveVendorListToFile(new ArrayList<>(VendorList), filePath);
          
    }
    private void loadVendorDataFromFile() {
        VendorList.clear();
        ArrayList<Vendor> loadedList = fileHandler.loadVendorListFromFile(filePath);
        if (loadedList != null) 
        {
            VendorList.addAll(loadedList);
        }
}

    @FXML
    private void ConfirmOnClick(ActionEvent event) 
    {
        saveVendorDataToFile();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("It works");
        alert.showAndWait();
    }
    
}
