/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg213.amartya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author usnot
 */
public class MarketResearchController implements Initializable {

    @FXML
    private TableView<?> marketResearchTable;
    @FXML
    private TableColumn<?, ?> parameterColumn;
    @FXML
    private TableColumn<?, ?> valueColumn;
    @FXML
    private TextArea researchNotes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
