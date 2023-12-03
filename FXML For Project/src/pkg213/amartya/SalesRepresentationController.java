
package pkg213.amartya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;


public class SalesRepresentationController implements Initializable {

    @FXML
    private ListView<?> salesList;
    @FXML
    private TextArea salesDetails;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAdd(ActionEvent event) {
    }

    @FXML
    private void handleDelete(ActionEvent event) {
    }

    @FXML
    private void handleSave(ActionEvent event) {
    }
    
}
