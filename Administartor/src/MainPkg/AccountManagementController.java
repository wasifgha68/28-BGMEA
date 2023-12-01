/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class AccountManagementController implements Initializable 
{

    @FXML private TextField EmployeeNameTextField;
    @FXML private PasswordField EmployeePasswordTextField;
    @FXML private TextField EmployeeIDTextField;
    @FXML private DatePicker EmployeeDOJ;
    @FXML private ComboBox<String> EmployeeTypeComboBox;
    @FXML private TableView<AccountManagementTB> EmployeeDetailTable;
    @FXML private RadioButton AddNewEmployeeRB;
    @FXML private RadioButton DeactivateEmployeeRB;
    @FXML private RadioButton ModifyInfoRB;
    @FXML private TableColumn<AccountManagementTB, String> NameColTB;
    @FXML private TableColumn<AccountManagementTB, String> IDcolTb;
    @FXML private TableColumn<AccountManagementTB, String> TypeOfEmployeeColTB;
    @FXML private TableColumn<AccountManagementTB, LocalDate> DOJColTB;
    @FXML private TableColumn<AccountManagementTB, String> IDStatus;
    
    
    
    private ObservableList<AccountManagementTB>observableEmployeeList=FXCollections.observableArrayList();
    private ToggleGroup toggleGroup;
    private ArrayList<EymployeeDetails> employeeList = new ArrayList<>();
    

    private EmployeeFileHandler fileHandler = new EmployeeFileHandler();
    private String filePath = "employeeDetails.bin";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        EmployeeDetailTable.setItems(observableEmployeeList);
     
        employeeList = fileHandler.loadEmployeeListFromFile(filePath);
        populateEmployeeTable();
                                
        toggleGroup = new ToggleGroup();
        
        EmployeeDetailTable.setItems(observableEmployeeList);

        AddNewEmployeeRB.setToggleGroup(toggleGroup);
        DeactivateEmployeeRB.setToggleGroup(toggleGroup);
        ModifyInfoRB.setToggleGroup(toggleGroup);
        ObservableList<String> employeeTypes = FXCollections.observableArrayList("Full-Time", "Part-Time", "Contract", "Intern");
        EmployeeTypeComboBox.setItems(employeeTypes);
        
        NameColTB.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IDcolTb.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        TypeOfEmployeeColTB.setCellValueFactory(new PropertyValueFactory<>("TypeOfEmployee"));
        DOJColTB.setCellValueFactory(new PropertyValueFactory<>("dateOfJoining"));
        IDStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
        EmployeeDetailTable.setItems(observableEmployeeList);
    }  
    
    private void modifyEmployeeByNameOrID(String name, String employeeID, String newPassword, LocalDate newDOJ, String newEmployeeType) 
    {
        boolean existsWithName = false;
        boolean existsWithID = false;
        EymployeeDetails matchedEmployee = null;
        for (EymployeeDetails employee : employeeList) 
        {
            if (employee.getEmployeeName().equalsIgnoreCase(name)) 
            {
                existsWithName = true;
                matchedEmployee = employee;
                break;
            }
            if (employee.getEmployeeID().equalsIgnoreCase(employeeID)) 
            {
                existsWithID = true;
                matchedEmployee = employee;
                break;
            }
        }
        if (existsWithName || existsWithID) 
        {
            matchedEmployee.setPassword(newPassword);
            matchedEmployee.setDateOfJoining(newDOJ);

            matchedEmployee.setEmployeeType(newEmployeeType);
            if (existsWithName) 
            { 
                matchedEmployee.setEmployeeID(employeeID);
            }
            else if (existsWithID) 
            {
                matchedEmployee.setEmployeeName(name);
            }
     
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Employee details modified: " + matchedEmployee.getEmployeeName());
            successAlert.showAndWait();
        } 
        else 
        {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
           errAlert.setTitle("Error");
           errAlert.setHeaderText("Employee not found");
           errAlert.setContentText("Employee with provided Name or ID does not exist.");
           errAlert.showAndWait();
        }
    }
    
    private boolean employeeExists(String name, String employeeID) 
    {
       boolean existsWithName = false;
       boolean existsWithID = false;
       for (EymployeeDetails employee : employeeList)
       {
           if (employee.getEmployeeName().equalsIgnoreCase(name)) 
           {
               existsWithName = true;
           }
           if (employee.getEmployeeID().equalsIgnoreCase(employeeID)) 
           {
               existsWithID = true;
           }
       }
       if (existsWithName || existsWithID) 
       {
           Alert errAlert = new Alert(Alert.AlertType.ERROR);
           errAlert.setTitle("Error");
           errAlert.setHeaderText("Employee already exists");
           if (existsWithName && existsWithID) 
           {
               errAlert.setContentText("An employee with the same Name and ID already exists.");
           } 
           else if (existsWithName) 
           {
               errAlert.setContentText("An employee with the same Name already exists.");
           } 
           else 
           {
               errAlert.setContentText("An employee with the same ID already exists.");
           }
           errAlert.showAndWait();
           return true; 
       }
       return false; 
    }
    
    private String getAccountStatus() {
    if (AddNewEmployeeRB.isSelected()) {
        return "Active";
    } else if (DeactivateEmployeeRB.isSelected()) {
        return "Inactive";
    } else {
        return "Active"; 
    }
    }

    @FXML
    private void GenerateEmployeeDetailsOnClick(ActionEvent event) 
    {
        
        
        String status = getAccountStatus();
        if (AddNewEmployeeRB.isSelected()) 
        {
             
            
            String name = EmployeeNameTextField.getText();
            String password = EmployeePasswordTextField.getText();
            String employeeID = EmployeeIDTextField.getText();
            LocalDate dateOfJoining = EmployeeDOJ.getValue();
            String employeeType = (String) EmployeeTypeComboBox.getValue();
             if (employeeExists(name, employeeID)) 
             {
                 return; 
             }
            if (name != null && !name.isEmpty() && password != null && !password.isEmpty()
                    && employeeID != null && !employeeID.isEmpty() && dateOfJoining != null
                    && employeeType != null && !employeeType.isEmpty()) 
            {
                EymployeeDetails newEmployee = new EymployeeDetails(name, password, employeeID, dateOfJoining, employeeType,status);
                employeeList.add(newEmployee);
                System.out.println("New employee added: " + newEmployee.getEmployeeName());
                newEmployee.setStatus("Active");
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("New employee added: " + newEmployee.getEmployeeName());
                successAlert.showAndWait();
            } 
            else 
            {
              Alert errAlert = new Alert(Alert.AlertType.ERROR);
              errAlert.setTitle("Error Alert");
              errAlert.setHeaderText("Error!");
              errAlert.setContentText("Please fill in all the fields.");
              errAlert.showAndWait();  
            }
        }
        else if (ModifyInfoRB.isSelected())
        {
            String name = EmployeeNameTextField.getText();
            String employeeID = EmployeeIDTextField.getText();
            String newPassword = EmployeePasswordTextField.getText();
            LocalDate newDOJ = EmployeeDOJ.getValue();
            String newEmployeeType = (String) EmployeeTypeComboBox.getValue();

            boolean exists = false;
            for (Object emp : employeeList) 
            {
                EymployeeDetails employee = (EymployeeDetails) emp;
                if (employee.getEmployeeName().equalsIgnoreCase(name) || employee.getEmployeeID().equalsIgnoreCase(employeeID)) 
                {
                    exists = true;
                    break;
                }
            }

            if ((name != null && !name.isEmpty()) || (employeeID != null && !employeeID.isEmpty()))
            {
                modifyEmployeeByNameOrID(name, employeeID, newPassword, newDOJ, newEmployeeType);
            }
            else
            {
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle("Error");
                errAlert.setHeaderText("Incomplete details");
                errAlert.setContentText("Please provide either the name or ID of the employee.");
                errAlert.showAndWait();
            }
        }
        else if (DeactivateEmployeeRB.isSelected())
        {
            String name = EmployeeNameTextField.getText();
            String employeeID = EmployeeIDTextField.getText();
            
            boolean exists = false;
            for (Object emp : employeeList) 
            {
                EymployeeDetails employee = (EymployeeDetails) emp;
                if (employee.getEmployeeName().equalsIgnoreCase(name) || employee.getEmployeeID().equalsIgnoreCase(employeeID)) 
                {
                    exists = true;
                    break;
                }
            }
            if ((name != null && !name.isEmpty()) || (employeeID != null && !employeeID.isEmpty()))
            {
                if (exists) 
                {
                    for (Object emp : employeeList) 
                    {
                        EymployeeDetails employee = (EymployeeDetails) emp;
                        if (employee.getEmployeeName().equalsIgnoreCase(name) || employee.getEmployeeID().equalsIgnoreCase(employeeID)) 
                        {
                            employeeList.remove(employee); 
                            
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setTitle("Success");
                            successAlert.setHeaderText(null);
                            successAlert.setContentText("Employee removed: " + employee.getEmployeeName());
                            successAlert.showAndWait();
                            populateEmployeeTable();
                            break;
                        }
                    }
                        
                }
                if (!exists) 
                {
                    Alert errAlert = new Alert(Alert.AlertType.ERROR);
                    errAlert.setTitle("Error");
                    errAlert.setHeaderText("Employee not found");
                    errAlert.setContentText("Employee with provided ID or name does not exist.");
                    errAlert.showAndWait();
                }
            }
        }
        
    }

    @FXML
    private void ShowEmployeeDetailsTBOnClick(ActionEvent event) 
    {
        populateEmployeeTable();
        
    }
    
    
    private void populateEmployeeTable() 
    {
        
        observableEmployeeList.clear(); 
        for (EymployeeDetails employee : employeeList) 
        {
            AccountManagementTB employeeRow = new AccountManagementTB(
             employee.getEmployeeName(),
             employee.getEmployeeID(),
            employee.getEmployeeType(),
            employee.getDateOfJoining(),
            employee. getStatus()
        );
        observableEmployeeList.add(employeeRow);
        }
    }
 
    @FXML private void ConfirmEmployeeDetailsOnClick(ActionEvent event) 
    {
        
        fileHandler.saveEmployeeListToFile(employeeList, filePath);
        saveEmployeeListToFile();
    }
    
    private void saveEmployeeListToFile() 
    {
        try (FileOutputStream fileOut = new FileOutputStream("employeeDetails.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) 
        {

            objectOut.writeObject(employeeList);
            System.out.println("Employee details saved to employeeDetails.bin");
            
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Employee details saved to employeeDetails.bin");
            successAlert.showAndWait();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle("Error");
            errAlert.setHeaderText("File Save Error");
            errAlert.setContentText("Error while saving employee details to file.");
            errAlert.showAndWait();
        }
    }



    @FXML private void GenerateEmployeeDetailPDFOnClick(ActionEvent event) 
    {
        employeeList = fileHandler.loadEmployeeListFromFile(filePath);
        populateEmployeeTable();
        
    }
    
}
