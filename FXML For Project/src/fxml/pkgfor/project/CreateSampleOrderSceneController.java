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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CreateSampleOrderSceneController implements Initializable {

    @FXML
    private TextField catalogNumberTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField itemNameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
    }
    
}
