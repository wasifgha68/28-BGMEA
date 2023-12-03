/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class ProgramController implements Initializable {

    @FXML
    private TextField TrainigWebinerTextField;
    @FXML
    private DatePicker WebinerDatePicker;
    @FXML
    private TextArea WebinerDescription;
    @FXML
    private ComboBox<String> EmployeeNameComboBox;
    @FXML
    private RadioButton RequestIncidentRB;
    @FXML
    private RadioButton ModifyIncidentRB;
    @FXML
    private TableView<Program> WebinerTableView;
    @FXML
    private TableColumn<Program, String> ProgramNameColTB;
    @FXML
    private TableColumn<Program, LocalDate> DateColTB;
    @FXML
    private TableColumn<Program,String> DescriptionColTB;
    @FXML
    private TableColumn<Program,String> StatusColTB;
    
    private ObservableList<Program>Programlist = FXCollections.observableArrayList();
    private ToggleGroup toggleGroup;
    private EmployeeFileHandler employeeHandler = new EmployeeFileHandler();
    private ProgramFileHandler programHandler = new ProgramFileHandler();        
    private String filePath = "ProgramDetails.bin";

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        toggleGroup = new ToggleGroup();
        RequestIncidentRB.setToggleGroup(toggleGroup);
        ModifyIncidentRB.setToggleGroup(toggleGroup);
        
        ProgramNameColTB.setCellValueFactory(new PropertyValueFactory<>("webinarName"));
        DateColTB.setCellValueFactory(new PropertyValueFactory<>("date"));
        DescriptionColTB.setCellValueFactory(new PropertyValueFactory<>("description"));
        StatusColTB.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
        ArrayList<EymployeeDetails> employeeList = employeeHandler.loadEmployeeListFromFile("employeeDetails.bin");
        ObservableList<String> factoryManagers = FXCollections.observableArrayList();
        for (EymployeeDetails employee : employeeList) 
        {
            if (employee.getEmployeeType().equals("Factory Manager:")) 
            {
                factoryManagers.addAll(employee.getEmployeeName());
            }
        }
        
        EmployeeNameComboBox.getItems().addAll(factoryManagers);
        ArrayList<Program> loadedPrograms = programHandler.loadProgramListFromFile(filePath);
        if (loadedPrograms != null && !loadedPrograms.isEmpty()) 
        {
            Programlist.addAll(loadedPrograms);
        }
        WebinerTableView.setItems(Programlist);
        
        WebinerTableView.setOnMouseClicked(event -> {
    if (event.getClickCount() == 2) 
    {
        Program selectedProgram = WebinerTableView.getSelectionModel().getSelectedItem();
        if (selectedProgram != null) 
        {
            handleDeleteProgram(selectedProgram);
        }
    }
    });
    } 
    private void handleDeleteProgram(Program selectedProgram) {
    Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmAlert.setTitle("Confirm Deletion");
    confirmAlert.setHeaderText(null);
    confirmAlert.setContentText("Are you sure you want to delete this webinar request?");

    confirmAlert.showAndWait().ifPresent
        (buttonType -> {
        if (buttonType == ButtonType.OK) {
            boolean removed = Programlist.remove(selectedProgram);
            if (removed) {
                WebinerTableView.setItems(Programlist);
                programHandler.saveProgramListToFile(new ArrayList<>(Programlist), "ProgramDetails.bin");
                Alert infoAlert = new Alert(Alert.AlertType.CONFIRMATION);
                infoAlert.setTitle("Confirm Deletion");
                infoAlert.setHeaderText(null);
                infoAlert.setContentText("Webinar request deleted successfully!");
                
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
                errorAlert.setTitle(null);
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error deleting Webinar request");
                
            }
        }
    });
}

    @FXML
    private void RequestWebinerOnclick(ActionEvent event) 
    {
        
        String EmployeeName = EmployeeNameComboBox.getValue();
        LocalDate date = WebinerDatePicker.getValue();
        String WebinarName = TrainigWebinerTextField.getText();
        String description = WebinerDescription.getText();
        String Status="Pending";
        if (WebinarName.isEmpty() || date == null || EmployeeName == null || description.isEmpty() || Status.isEmpty()) 
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before proceeding.");
            alert.showAndWait();
        }
        else{
        if (RequestIncidentRB.isSelected()) 
        {
            handleAddIncident(WebinarName, date,EmployeeName, description,Status);
        } 
        else if (ModifyIncidentRB.isSelected()) 
        {
            handleModifyIncident(WebinarName, date,EmployeeName, description,Status);
        }
        WebinerTableView.refresh();
        }
        WebinerTableView.setItems(Programlist);
    }
    private void handleAddIncident(String webinarName, LocalDate date, String employeeName, String description, String status) 
    {
        boolean webinarExists = Programlist.stream().anyMatch(program -> program.getWebinarName().equals(webinarName));
        if (webinarExists) 
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("The Webinar request already exists");
            alert.showAndWait();
        } 
        else 
        { 
            Program newProgram = new Program(webinarName, date,employeeName, description, status);
            Programlist.add(newProgram);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Sucess New Webinar request Added");
            alert.showAndWait();
        }
    }
    private void handleModifyIncident(String webinarName, LocalDate date, String employeeName, String description, String status) 
    {
        Program existingProgram = Programlist.stream()
            .filter(program -> program.getWebinarName().equals(webinarName))
            .findFirst()
            .orElse(null);
        if (existingProgram != null) 
        {
            existingProgram.setDate(date);
            existingProgram.setDescription(description);
            existingProgram.setStatus(status);
        
        WebinerTableView.refresh();
    } else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("The Webinar does not exist for modification");
        alert.showAndWait();
    }
    }

    @FXML
    private void ConfirmOnClick(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException 
    {
        ProgramFileHandler programHandler = new ProgramFileHandler();        
        programHandler.saveProgramListToFile(new ArrayList<>(Programlist), "ProgramDetails.bin");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("The Webinar successfully saved to file");
        alert.showAndWait();
    }
    
}
