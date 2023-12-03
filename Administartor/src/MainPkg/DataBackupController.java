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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class DataBackupController implements Initializable {

    @FXML private ComboBox<String> DataTypeComboBox;
    @FXML private TextArea DataTextArea;

    private final EventFileHandler eventFileHandler = new EventFileHandler();
    private final EmployeeFileHandler employeeFileHandler = new EmployeeFileHandler();
    private final NewsFileHandler newsFileHandler = new NewsFileHandler();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataTypeComboBox.getItems().addAll("Event", "Employee","News");
    }

    @FXML
    private void ConfirmOnClick(ActionEvent event) {
        String selectedDataType = DataTypeComboBox.getValue();

        if (selectedDataType != null) {
            if (selectedDataType.equals("Event")) {
                ArrayList<Event2> events = eventFileHandler.loadEventListFromFile("event.bin");
                displayEventData(events);
            } else if (selectedDataType.equals("Employee")) {
                ArrayList<EymployeeDetails> employees = employeeFileHandler.loadEmployeeListFromFile("employeeDetails.bin");
                displayEmployeeData(employees);
            }
            else if (selectedDataType.equals("News")) 
            {
            ArrayList<News> newsList = newsFileHandler.loadNewsListFromFile("News.bin");
            displayNewsData(newsList);
            }
        
        }
    }
    private void displayNewsData(ArrayList<News> newsList) 
    {
        if (newsList != null && !newsList.isEmpty()) {
            StringBuilder display = generateNewsInfo(newsList);
            DataTextArea.setText(display.toString());
        } else {
            DataTextArea.setText("No news data found.");
        }
    }
    private StringBuilder generateNewsInfo(ArrayList<News> newsList) 
    {
        StringBuilder display = new StringBuilder();
        for (News news : newsList) {
            // Customize the format based on your News structure
            display.append("Headline: ").append(news.getHeadline()).append("\n")
                   .append("Date: ").append(news.getDate()).append("\n")
                   .append("Status: ").append(news.getStatus()).append("\n").append(news.getDescription())
                   .append("\n").append("........").append("\n");
        }
        return display;
    }

    private void displayEventData(ArrayList<Event2> dataList) {
        if (dataList != null && !dataList.isEmpty()) {
            StringBuilder display = generateEventInfo(dataList);
            DataTextArea.setText(display.toString());
        } else {
            DataTextArea.setText("No event data found.");
        }
    }

    private void displayEmployeeData(ArrayList<EymployeeDetails> dataList) {
        if (dataList != null && !dataList.isEmpty()) {
            StringBuilder display = generateEmployeeInfo(dataList);
            DataTextArea.setText(display.toString());
        } else {
            DataTextArea.setText("No employee data found.");
        }
    }

    private StringBuilder generateEventInfo(ArrayList<Event2> dataList) {
        StringBuilder display = new StringBuilder();
        for (Event2 data : dataList) {
            // Customize the format based on your Event2 structure
            display.append("Name: ").append(data.getName()).append("\n")
                   .append("Event Name: ").append(data.getEventName()).append("\n").append("Description: ").append(data.getDescription())
                   .append("\n").append("......").append("\n");
        }
        return display;
    }

    private StringBuilder generateEmployeeInfo(ArrayList<EymployeeDetails> dataList) {
        StringBuilder display = new StringBuilder();
        for (EymployeeDetails data : dataList) {
            // Customize the format based on your EymployeeDetails structure
            display.append("Employee ID: ").append(data.getEmployeeID())
                   .append(", Employee Name: ").append(data.getEmployeeName())
                   .append("\n");
        }
        return display;
    }

}


        
  
