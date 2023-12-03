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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Amartya
 */
public class IMController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField ItemNameFxid;
    @FXML
    private TextField amountFxid;
    @FXML
    private TextField Valuefxid;
    @FXML
    private TableColumn<IMController, String> NameTable;
    @FXML
    private TableColumn<IMController, String> Amounttable;
    @FXML
    private TableColumn<IMController, Double> valuetable;
    @FXML
    private TableView<IMController> TableFxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addInventory(ActionEvent event) {
    }

    @FXML
    private void DeleteList(ActionEvent event) {
    }

    @FXML
    private void SaveList(ActionEvent event) {
    }
    
}
