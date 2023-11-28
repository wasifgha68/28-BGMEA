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
public class JobProgressSceneController implements Initializable {

    @FXML
    private TableColumn<JobProgress, String> statusTable;
    @FXML
    private TableColumn<JobProgress, String> progressTable;
    @FXML
    private TableView<JobProgress> jobProgressTable;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField progressTextField;
    @FXML
    private TableColumn<JobProgress, String> taskTable;
    @FXML
    private TextField tasksTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        taskTable.setCellValueFactory(new PropertyValueFactory<>("tasks"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("status"));
        progressTable.setCellValueFactory(new PropertyValueFactory<>("progress"));
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JobProgress.bin"))) {
            ArrayList<JobProgress> items = (ArrayList<JobProgress>) ois.readObject();
            jobProgressTable.getItems().setAll(items);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }    
    
    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        String tasks = tasksTextField.getText();
        String status = statusTextField.getText();
        String progress = progressTextField.getText();

        JobProgress newItem = new JobProgress(tasks, status, progress);

        jobProgressTable.getItems().add(newItem);

        tasksTextField.clear();
        statusTextField.clear();
        progressTextField.clear();
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        JobProgress selectedItem = jobProgressTable.getSelectionModel().getSelectedItem();
        jobProgressTable.getItems().remove(selectedItem);
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<JobProgress> tableData = new ArrayList<>();
            for (JobProgress item : jobProgressTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JobProgress.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                System.out.println("Exception occured " + e);
            }
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }
    
    
}
