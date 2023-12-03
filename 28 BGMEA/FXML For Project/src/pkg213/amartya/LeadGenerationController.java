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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author usnot
 */
public class LeadGenerationController implements Initializable {

    @FXML
    private TableView<?> leadsTable;
    @FXML
    private TableColumn<?, ?> leadNameColumn;
    @FXML
    private TableColumn<?, ?> contactInfoColumn;
    @FXML
    private Button addLeadButton;
    @FXML
    private Button deleteLeadButton;
    @FXML
    private Button saveLeadButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAddLead(ActionEvent event) {
    }

    @FXML
    private void handleDeleteLead(ActionEvent event) {
    }

    @FXML
    private void handleSaveLead(ActionEvent event) {
    }
    
}
