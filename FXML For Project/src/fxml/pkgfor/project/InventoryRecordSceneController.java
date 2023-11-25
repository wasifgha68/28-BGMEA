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
public class InventoryRecordSceneController implements Initializable {

    @FXML
    private ComboBox<?> inventoryTypeComboBox;
    @FXML
    private TableColumn<?, ?> nameTable;
    @FXML
    private TableColumn<?, ?> unitTable;
    @FXML
    private TableColumn<?, ?> inventoryValueTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
    }
    
}
