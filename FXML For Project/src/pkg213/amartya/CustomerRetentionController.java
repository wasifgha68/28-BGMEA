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
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amartya
 */
public class CustomerRetentionController implements Initializable {

    @FXML
    private TableView<?> customerRetentionTable;
    @FXML
    private TextField customerNameInput;
    @FXML
    private TextField lastPurchaseDateInput;
    @FXML
    private TextField purchaseFrequencyInput;
    @FXML
    private Button addToTableButton;
    @FXML
    private Button saveDataButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAddToTableAction(ActionEvent event) {
    }

    @FXML
    private void handleSaveDataAction(ActionEvent event) {
    }
    
}
