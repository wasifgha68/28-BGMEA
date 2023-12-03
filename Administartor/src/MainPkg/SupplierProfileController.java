/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.io.IOException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class SupplierProfileController implements Initializable {

    @FXML
    private TextField SupplierNameTextField;
    @FXML
    private TextField SupplierIDTextField;
    @FXML
    private TextField SupplierContactTextField;
    @FXML
    private DatePicker DOJDatePicker;
    @FXML
    private RadioButton AddNewSupplierRB;
    @FXML
    private RadioButton ModifySupplierInformationRB;
    @FXML
    private RadioButton DeleteSupplierRB;
    @FXML
    private TableView<SupplierTableView> SupplierTB;
    @FXML
    private TableColumn<SupplierTableView, String> SupplierNameColTB;
    @FXML
    private TableColumn<SupplierTableView, String> SupplierIDTB;
    @FXML
    private TableColumn<SupplierTableView, String> SupplierContactColTB;
    @FXML
    private TableColumn<SupplierTableView, LocalDate> DOJColTB;

    private ObservableList<SupplierTableView>supplierList = FXCollections.observableArrayList();
    private ToggleGroup toggleGroup;
    
    private SupplierFileHandler fileHandler = new SupplierFileHandler();
    private String filePath = "supplierDetails.bin";
    
    @Override public void initialize(URL url, ResourceBundle rb) 
    {
        toggleGroup = new ToggleGroup();
        AddNewSupplierRB.setToggleGroup(toggleGroup);
        ModifySupplierInformationRB.setToggleGroup(toggleGroup);
        DeleteSupplierRB.setToggleGroup(toggleGroup);
        
        SupplierNameColTB.setCellValueFactory(new PropertyValueFactory<>("name"));
        SupplierIDTB.setCellValueFactory(new PropertyValueFactory<>("id"));
        SupplierContactColTB.setCellValueFactory(new PropertyValueFactory<>("contact"));
        DOJColTB.setCellValueFactory(new PropertyValueFactory<>("dateOfJoining"));
    } 
    
    @FXML private void GenerateSupplierDetailsOnClick(ActionEvent event) 
    {
        
        if (AddNewSupplierRB.isSelected()) 
        {
            handleAddNewSupplier();
            
        } 
        else if (ModifySupplierInformationRB.isSelected()) 
        {
            handleModifySupplier();
        } 
        else if (DeleteSupplierRB.isSelected()) 
        {
            handleDeleteSupplier();
        }
    }
    private void handleAddNewSupplier() {
    String name = SupplierNameTextField.getText();
    String id = SupplierIDTextField.getText();
    String contact = SupplierContactTextField.getText();
    LocalDate dateOfJoining = DOJDatePicker.getValue();

    if (name.isEmpty() || id.isEmpty() || contact.isEmpty() || dateOfJoining == null) 
    {
        
        showIncompleteDetailsAlert();
        return;
    }

    if (supplierExists(name, id)) 
    {
  
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Supplier already exists");
        alert.setContentText("A supplier with the same Name or ID already exists.");
        alert.showAndWait();
        return;
    }
    SupplierTableView newSupplier = new SupplierTableView(name, id, contact, dateOfJoining);
    supplierList.add(newSupplier);
    clearInputFields();
    saveSupplierDataToFile();  
    SupplierTB.setItems(supplierList);
    }
    private void handleModifySupplier() 
    {
        
        String name = SupplierNameTextField.getText();
        String id = SupplierIDTextField.getText();
        String contact = SupplierContactTextField.getText();
        LocalDate dateOfJoining = DOJDatePicker.getValue();
        if (name.isEmpty() || id.isEmpty() || contact.isEmpty() || dateOfJoining == null) 
        {
            showIncompleteDetailsAlert();
            return;
        }
        boolean found = false;
        for (SupplierTableView supplier : supplierList) 
        {
            if (supplier.getName().equalsIgnoreCase(name) && supplier.getId().equalsIgnoreCase(id)) 
            {
                supplier.setName(name);
                supplier.setId(id);
                supplier.setContact(contact);
                supplier.setDateOfJoining(dateOfJoining);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Supplier Not Found");
            alert.setContentText("The supplier details you're trying to modify do not exist.");
            alert.showAndWait();
            return;
        }
        clearInputFields();
        saveSupplierDataToFile();
        SupplierTB.setItems(supplierList);
        
        
    }
    private void handleDeleteSupplier() 
    {
        String name = SupplierNameTextField.getText();
        String id = SupplierIDTextField.getText();
        boolean found = false;
        for (SupplierTableView supplier : supplierList) 
        {
            if (supplier.getName().equalsIgnoreCase(name) && supplier.getId().equalsIgnoreCase(id)) 
            {
                supplierList.remove(supplier);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Supplier Not Found");
            alert.setContentText("The supplier details you're trying to delete do not exist.");
            alert.showAndWait();
            return;
        }
        clearInputFields();
        saveSupplierDataToFile();
        SupplierTB.setItems(supplierList);
        
    }
    private boolean supplierExists(String name, String ID) {
    for (SupplierTableView supplier : supplierList) {
        if (supplier.getName().equalsIgnoreCase(name) || supplier.getId().equalsIgnoreCase(ID)) {
            return true; 
        }
    }
    return false;
    }

        

    
    private void showIncompleteDetailsAlert() 
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incomplete Details");
        alert.setContentText("Please fill in all fields.");
        alert.showAndWait();
    }
    private void clearInputFields() 
    {
        SupplierNameTextField.clear();
        SupplierIDTextField.clear();
        SupplierContactTextField.clear();
        DOJDatePicker.getEditor().clear(); 
    }
    

 
  
    

    @FXML private void ViewSupplierDetailsOnClick(ActionEvent event) 
    {
        loadSupplierDataFromFile();
        SupplierTB.setItems(supplierList);
    }

    @FXML
    private void ConfirmOnClick(ActionEvent event) 
    {
        saveSupplierDataToFile() ;
    }
    private void saveSupplierDataToFile() {
        fileHandler.saveSupplierListToFile(new ArrayList<>(supplierList), filePath);
    }
    private void loadSupplierDataFromFile() {
        supplierList.clear();
        ArrayList<SupplierTableView> loadedList = fileHandler.loadSupplierListFromFile(filePath);
        if (loadedList != null) 
        {
            supplierList.addAll(loadedList);
        }
    }
}

    

