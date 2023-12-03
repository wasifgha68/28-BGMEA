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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author usnot
 */
public class ECController implements Initializable {

    @FXML
    private TextField exportItem;
    @FXML
    private TextField destinationCountry;
    @FXML
    private DatePicker shipmentDate;
    @FXML
    private TextArea complianceNotes;
    @FXML
    private Button submitCompliance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitComplianceInfo(ActionEvent event) {
    }
    
}
