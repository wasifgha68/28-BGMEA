/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;



public class Event2Controller implements Initializable {

    @FXML private TextField EmployeeNameTextField;
    @FXML private ComboBox<String> EmployeeTypeComboBox;
    @FXML private PasswordField EmployeePasswordTextField;
    @FXML private ComboBox<String> EventTypeComboBox;
    @FXML private TextField EventNameTextField;
    @FXML private DatePicker StartDatePicker;
    @FXML private DatePicker EndDatePicker;
    @FXML private TextArea EventDescriptionTextarea;
    @FXML private Button GenerateEventOnClick;
    @FXML private TableView<EventTableView> EventTableView;
    @FXML private TableColumn<EventTableView, String> NameColTB;
    @FXML private TableColumn<EventTableView,String> DesignationColTB;
    @FXML private TableColumn<EventTableView,String> EventNameColTB;
    @FXML private TableColumn<EventTableView,String> StartDateColTB;
    @FXML private TableColumn<EventTableView,String> EndDateColTB;
    @FXML private TableColumn<EventTableView,String> StatusColTB;
    @FXML private RadioButton AddRB;
    @FXML private RadioButton ModifyRB;
    @FXML private RadioButton CancelRB;
    
    private EventFileHandler fileHandler = new EventFileHandler();
    private String filePath = "event.bin";

    private ObservableList<EventTableView> observableEmployeeList = FXCollections.observableArrayList();
    private ArrayList<Event2> eventList = new ArrayList<>();
    private ObservableList<EventTableView> observableEventList = FXCollections.observableArrayList(); // Corrected variable name
    private ToggleGroup toggleGroup;
    private ObservableList<EymployeeDetails> employeeList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        toggleGroup = new ToggleGroup();
        AddRB.setToggleGroup(toggleGroup);
        ModifyRB.setToggleGroup(toggleGroup);
        CancelRB.setToggleGroup(toggleGroup);
        
        NameColTB.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        DesignationColTB.setCellValueFactory(new PropertyValueFactory<>("employeeType"));
        EventNameColTB.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        StartDateColTB.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        EndDateColTB.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        StatusColTB.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        EventTypeComboBox.getItems().addAll("Holiday", "Leave", "Normal Event");
        ObservableList<String> employeeType = FXCollections.observableArrayList("Full-Time", "Part-Time", "Contract", "Intern");
        EmployeeTypeComboBox.setItems(employeeType);
    } 
    private void compareNamesAndAlert(String nameToCompare) 
    {
        try (FileInputStream fileIn = new FileInputStream("employeeDetails.bin");
         ObjectInputStream objectIn = new ObjectInputStream(fileIn)) 
        {
            employeeList = FXCollections.observableArrayList((ArrayList<EymployeeDetails>) objectIn.readObject());
            boolean nameFound = false;
            for (EymployeeDetails employee : employeeList) 
            {
                if (employee.getEmployeeName().equals(nameToCompare)) 
                {
                    nameFound = true;
                    break;
                }
            }
            if (nameFound) 
            {
                showAlert("Employee Found", "Employee with the given name exists.");
            } 
            else 
            {
                showAlert("Employee Not Found", "No employee with the given name found.");
            }
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
            showAlert("Error", "Error loading employee details from the binary file.");
        }
    }
    private void showAlert(String title, String content) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    @FXML private void GenerateEventOnClick(ActionEvent event) 
    {
        String nameToCompare = EmployeeNameTextField.getText();
        compareNamesAndAlert(nameToCompare);

        if (AddRB.isSelected()) {
            addNewEvent();
        } else if (ModifyRB.isSelected()) {
            modifyEvent();             
        } else if (CancelRB.isSelected()) {
            cancelEvent();           
        }
    }
    
    
    private void addNewEvent() 
    {      
        String name = EmployeeNameTextField.getText();
        String employeeType = EmployeeTypeComboBox.getValue();
        String eventType = EventTypeComboBox.getValue();
        String eventName = EventNameTextField.getText();
        LocalDate startDate = StartDatePicker.getValue();
        LocalDate endDate = EndDatePicker.getValue();
        String description = EventDescriptionTextarea.getText();
        String status = "Active";
        boolean eventExists = eventList.stream().anyMatch(event -> event.getEventName().equals(eventName));
        if (!eventExists) 
        {
            Event2 newEvent = new Event2(name, employeeType, eventType, eventName, startDate, endDate, description, status);
            eventList.add(newEvent);
            fileHandler.saveEventListToFile(eventList, filePath);
        } else 
        {
            showAlert("Event Exists", "An event with the same name already exists in the list.");}
    }
    private void modifyEvent() 
    {
        String nameToCompare = EventNameTextField.getText();
        boolean eventFound = false;
        for (Event2 event : eventList) 
        {
            if (event.getEventName().equals(nameToCompare)) 
            {
                event.setEmployeeType(EmployeeTypeComboBox.getValue());
                event.setEventType(EventTypeComboBox.getValue());
                event.setEventName(EventNameTextField.getText());
                event.setStartDate(StartDatePicker.getValue());
                event.setEndDate(EndDatePicker.getValue());
                event.setDescription(EventDescriptionTextarea.getText());
                showAlert("Event Modified", "Event details modified successfully.");
                eventFound = true;
                break;
            }
        }
        if (!eventFound) 
        {
            showAlert("Event Not Found", "No event found to modify.");
        } 
        else
        {
            fileHandler.saveEventListToFile(eventList, filePath);
        }
    }
    private void cancelEvent() 
    {
        String nameToCompare = EventNameTextField.getText();
        Event2 eventToRemove = null;
        for (Event2 event : eventList) 
        {
            if (event.getEventName().equals(nameToCompare)) 
            {
                eventToRemove = event;
                break;
            }
        }
        if (eventToRemove != null) 
        {
            eventList.remove(eventToRemove);
            showAlert("Event Canceled", "Event canceled and removed from the list.");
            fileHandler.saveEventListToFile(eventList, filePath);
        } 
        else 
        {
            showAlert("Event Not Found", "No event found to cancel.");
        }
    }

    


        
    
    
    
    private void populateEventTable() 
    {
        observableEventList.clear();
        eventList = fileHandler.loadEventListFromFile(filePath);
        for (Event2 event : eventList) {
            EventTableView eventRow = new EventTableView(
                event.getName(),
                event.getEmployeeType(),
                event.getEventType(),
                event.getStartDate(),
                event.getEndDate(),
                event.getStatus()
            );
            observableEventList.add(eventRow);
        }
        EventTableView.setItems(observableEventList);
        EventTableView.refresh();
    }
    
    

   
    
        
    

    @FXML
    private void ViewEventOnClick(ActionEvent event) 
    {
        populateEventTable();
    }

    @FXML
    private void ConfirmOnClick(ActionEvent event) 
    {
        fileHandler.saveEventListToFile(eventList, filePath);
        
        
    }
    private void printEventList() 
    {
        System.out.println("Event List:");
        for (Event2 event : eventList)
        {
            System.out.println(event); 
        }
    }
    
}
