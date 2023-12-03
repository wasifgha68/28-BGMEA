/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class IncidentController implements Initializable 
{

    @FXML private TextField IncidentNameTextField;
    @FXML private TableView<Incident> IncidentTableView;
    @FXML private TableColumn<Incident, String> IncidentColTB;
    @FXML private TableColumn<Incident, LocalDate> DateColTB;
    @FXML private TableColumn<Incident,String> EmployeeInvolvedTB;
    @FXML private DatePicker IncidentDatePicker;
    @FXML private TextArea DescriptionTextArea;
    @FXML private RadioButton AddIncidentRB;
    @FXML private RadioButton ModifyIncidentRB;
    @FXML private TextField EmployeeNameTextField;
    
    private ObservableList<Incident>incidentlist = FXCollections.observableArrayList();
    private ToggleGroup toggleGroup;
    private  incidentFileHandler fileHandler = new incidentFileHandler(); 
    private EmployeeFileHandler employeeHandler = new EmployeeFileHandler();        
    private String filePath = "IncidentDetails.bin";
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        toggleGroup = new ToggleGroup();
        AddIncidentRB.setToggleGroup(toggleGroup);
        ModifyIncidentRB.setToggleGroup(toggleGroup);
        
        IncidentColTB.setCellValueFactory(new PropertyValueFactory<>("incidentName"));
        DateColTB.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmployeeInvolvedTB.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        
        List<Incident> loadedIncidents = fileHandler.loadIncidentListFromFile(filePath);
        if (loadedIncidents != null) 
        {
        incidentlist.addAll(loadedIncidents);
        IncidentTableView.setItems(incidentlist);
        }
       
        IncidentTableView.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2)
        { 
            Incident selectedIncident = IncidentTableView.getSelectionModel().getSelectedItem();
            if (selectedIncident != null) 
            {
                handleDeleteIncident(selectedIncident);
            }
        }
    
        });
    }
    private void handleDeleteIncident(Incident selectedIncident) 
    { 
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Are you sure you want to delete this incident?");
    
        confirmAlert.showAndWait().ifPresent(buttonType -> 
        {
            if (buttonType == ButtonType.OK) 
            {
                boolean removed = incidentlist.remove(selectedIncident);
                if (removed) 
                {
                    IncidentTableView.setItems(incidentlist);
                    saveIncidentsToFile();
                    showAlert("Incident deleted successfully!");
                } 
                else 
                {
                    showAlert("Error deleting incident!");
                }
        }
        });
    }
    private void loadIncidentsFromFile() 
    {
        List<Incident> loadedIncidents = fileHandler.loadIncidentListFromFile(filePath); 
        if (loadedIncidents != null) 
        {
            incidentlist.addAll(loadedIncidents);
            IncidentTableView.setItems(incidentlist);
        }
    }
    private void saveIncidentsToFile() 
    {
        fileHandler.saveIncidentListToFile(new ArrayList<>(incidentlist), filePath); 
    }
    

    @FXML private void ReportIncidentOnClick(ActionEvent event) 
    {
        String incidentName = IncidentNameTextField.getText();
        LocalDate date = IncidentDatePicker.getValue();
        String employeeName = EmployeeNameTextField.getText();
        String description = DescriptionTextArea.getText();
        EmployeeFileHandler employeeHandler = new EmployeeFileHandler();
        String employeeFilePath = "employeeDetails.bin";
        
        ArrayList<EymployeeDetails> employeeList = employeeHandler.loadEmployeeListFromFile("EmployeeDetails.bin");
        boolean employeeExists = employeeList.stream().anyMatch(employee -> employee.getEmployeeName().equals(employeeName));

        if (!employeeExists)
        {
            showAlert("Employee does not exist. Please enter a valid employee name.");
            return;
        }                
        else
        {
            if (AddIncidentRB.isSelected()) 
            {
                handleAddIncident(incidentName, date, employeeName, description);
            } 
            else if (ModifyIncidentRB.isSelected()) 
            {
                handleModifyIncident(incidentName, date, employeeName, description);
            }
            IncidentTableView.refresh();
        }        
    }
    private void handleAddIncident(String incidentName, LocalDate date, String employeeName, String description) 
    {
        if (!incidentExists(incidentName) && !eventNameExists(incidentName)) 
        {
            Incident newIncident = new Incident(employeeName, incidentName, date, description);
            incidentlist.add(newIncident);
            showAlert("Incident added successfully");
            IncidentTableView.setItems(incidentlist);
        } 
        else 
        {
            showAlert("Incident already exists");
        }
    }
    private void handleModifyIncident(String incidentName, LocalDate date, String employeeName, String description) 
    {
        Incident foundIncident = incidentlist.stream()
            .filter(incident -> incident.getIncidentName().equals(incidentName))
            .findFirst()
            .orElse(null);
        if (foundIncident != null) 
        {
            foundIncident.setDate(date);
            foundIncident.setEmployeeName(employeeName);
            foundIncident.setDescription(description);
            showAlert("Incident modified successfully");
            IncidentTableView.setItems(incidentlist);
        } 
        else 
        {
            showAlert("Incident doesn't exist");
        }
    } 
    private void showAlert(String message) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private boolean eventNameExists(String incidentName) 
    {
        return incidentlist.stream().anyMatch(incident -> incident.getIncidentName().equals(incidentName));
    }
    private boolean incidentExists(String incidentName) 
    {
        for (Incident incident : incidentlist) 
        {
            if (incident.getIncidentName().equals(incidentName)) 
            {
                return true;
            }
        }
        return false;
    }
    @FXML private void ConfirmOnClick(ActionEvent event) 
    {
        
        fileHandler.saveIncidentListToFile(new ArrayList<>(incidentlist), filePath);
        showAlert("Incident list saved successfully!");
        
    }
    
}
