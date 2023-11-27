/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReviseScheduleSceneController implements Initializable {

    @FXML
    private TableColumn<ReviseSchedule, String> empIdTable;
    @FXML
    private TableColumn<ReviseSchedule, String> shiftTimeTable;
    @FXML
    private TableColumn<ReviseSchedule, String> taskTable;
    @FXML
    private TableView<ReviseSchedule> scheduleTable;
    @FXML
    private TextField empIDTextField;
    @FXML
    private TextField shiftTimesTextField;
    @FXML
    private TextField taskTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empIdTable.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        shiftTimeTable.setCellValueFactory(new PropertyValueFactory<>("shiftTimes"));
        taskTable.setCellValueFactory(new PropertyValueFactory<>("tasks"));
    }    

    @FXML
    private void loadScheduleOnMouseClicked(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Schedule.bin"))) {
            ArrayList<ReviseSchedule> items = (ArrayList<ReviseSchedule>) ois.readObject();
            scheduleTable.getItems().setAll(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveScheduleOnMouseClicked(ActionEvent event) {
        try {
            List<ReviseSchedule> tableData = new ArrayList<>();
            for (ReviseSchedule item : scheduleTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Schedule.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        int empID = Integer.parseInt(empIDTextField.getText());
        String shiftTimes = shiftTimesTextField.getText();
        String task = taskTextField.getText();

        ReviseSchedule newItem = new ReviseSchedule(empID, shiftTimes, task);

        scheduleTable.getItems().add(newItem);

        empIDTextField.clear();
        shiftTimesTextField.clear();
        taskTextField.clear();
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        ReviseSchedule selectedItem = scheduleTable.getSelectionModel().getSelectedItem();
        scheduleTable.getItems().remove(selectedItem);
    }
    
}
