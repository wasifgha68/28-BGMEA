/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg213.amartya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amartya
 */
public class SCOController implements Initializable {

    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField quantityfxid;
    @FXML
    private DatePicker datefxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().addAll("Bus","Truck","Ship");
        // TODO
    }    

    @FXML
    private void done(ActionEvent event) {
    }
    
}
