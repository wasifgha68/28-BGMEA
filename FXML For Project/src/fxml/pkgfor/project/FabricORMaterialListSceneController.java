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
public class FabricORMaterialListSceneController implements Initializable {

    @FXML
    private ComboBox<?> typeComboBox;
    @FXML
    private TableColumn<?, ?> itemTable;
    @FXML
    private TableColumn<?, ?> unitTable;
    @FXML
    private TableColumn<?, ?> unitPriceTable;
    @FXML
    private TableColumn<?, ?> totalPriceTable;
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
    private void loadOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
    }
    
}
