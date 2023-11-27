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
public class JobsSceneController implements Initializable {

    @FXML
    private TableColumn<Jobs, String> statusTable;
    @FXML
    private TableView<Jobs> jobsTable;
    @FXML
    private TableColumn<Jobs, String> empIDTable;
    @FXML
    private TableColumn<Jobs, String> skillTable;
    @FXML
    private TextField empIDTextField;
    @FXML
    private TextField skillTextField;
    @FXML
    private TextField statusTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empIDTable.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        skillTable.setCellValueFactory(new PropertyValueFactory<>("skill"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Jobs.bin"))) {
            ArrayList<Jobs> items = (ArrayList<Jobs>) ois.readObject();
            jobsTable.getItems().setAll(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        int employeeID = Integer.parseInt(empIDTextField.getText());
        String skill = skillTextField.getText();
        String status = statusTextField.getText();

        Jobs newItem = new Jobs(employeeID, skill, status);

        jobsTable.getItems().add(newItem);

        empIDTextField.clear();
        skillTextField.clear();
        statusTextField.clear();
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        Jobs selectedItem = jobsTable.getSelectionModel().getSelectedItem();
        jobsTable.getItems().remove(selectedItem);
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<Jobs> tableData = new ArrayList<>();
            for (Jobs item : jobsTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Jobs.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
