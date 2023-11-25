/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CostReportSceneController implements Initializable {

    @FXML
    private ComboBox<?> projectComboBox;
    @FXML
    private TableColumn<?, ?> dateTable;
    @FXML
    private TableColumn<?, ?> itemNameTable;
    @FXML
    private TableColumn<?, ?> totalSpentTable;
    @FXML
    private TableColumn<?, ?> notesTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadProjectOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void saveProjectOnMouseClicked(ActionEvent event) {
    }
    
}
