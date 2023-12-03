package MainPkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AdministratorDashBoardController implements Initializable {

    @FXML private AnchorPane anchorpane; // fx:id added

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Load the default scene when initializing
            loadFXML("NewsDashBoard.fxml");
        } catch (IOException ex) {
            Logger.getLogger(AdministratorDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void DataBackUpOnClick(ActionEvent event) {
        try {
            loadFXML("DataBackup.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AccountManagementOnClick(ActionEvent event) {
        try {
            loadFXML("AccountManagement.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void EventReviewOnClick(ActionEvent event) {
        try {
            loadFXML("Event2.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void loadFXML(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        AnchorPane pane = loader.load();
        anchorpane.getChildren().setAll(pane); 
    }

    @FXML
    private void NewsDashboardOnClick(ActionEvent event) 
    {
        try {
        loadFXML("NewsDashBoard.fxml");
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void AddNewsOnClick(ActionEvent event) 
    {
         try {
        loadFXML("AddNews.fxml");
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    

    
}
    

