package pkg213.amartya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 */
public class ShippingandLogisticsCoordinatorDashboardController implements Initializable {

    @FXML
    private BorderPane borderid;
    @FXML
    private AnchorPane screen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SCO(ActionEvent event) {
        loadScene("SCO.fxml");
    }

    @FXML
    private void IM(ActionEvent event) {
        loadScene("IM.fxml");
    }

    @FXML
    private void TD(ActionEvent event) {
        loadScene("TD.fxml");
    }

    @FXML
    private void EC(ActionEvent event) {
        loadScene("EC.fxml");
    }

    @FXML
    private void CR(ActionEvent event) {
        loadScene("CR.fxml");
    }

    @FXML
    private void LCC(ActionEvent event) {
        loadScene("LCC.fxml");
    }

    @FXML
    private void RML(ActionEvent event) {
        loadScene("RML.fxml");
    }

    @FXML
    private void TaV(ActionEvent event) {
        loadScene("TaV.fxml");
    }

    private void loadScene(String fxmlFile) {
        try {
            // Load the new scene
            Parent view = FXMLLoader.load(getClass().getResource(fxmlFile));
            
            // Set the new scene to the center of the border pane
            borderid.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (maybe show an error message)
        }
    }
}
