package MainPkg;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FactoryManagerDashboardController {

    @FXML
    private AnchorPane dashboardAnchorPane;
    @FXML
    private Label nameTextField;

    public void initialize() {
        try {
            // Load the default scene when initializing
            loadFXML("FactoryManagerDatacBackup.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
            // Handle the exception appropriately (show an error message, log, etc.)
        }
    }

    @FXML
    private void DataBackUPOnClick(ActionEvent event) {
        try {
            loadFXML("FactoryManagerDatacBackup.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
    @FXML private void ReportIncidentOnClick (ActionEvent event) {
        try {
            loadFXML("Incident.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void SupplierListOnClicked(ActionEvent event) {
        try {
            loadFXML("SupplierProfile.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML private void VendorListOnMouseClicked(ActionEvent event) {
        try {
            loadFXML("Vendor.fxml");
        } catch (IOException e) {
            e.printStackTrace();           
        }
    }
    @FXML private void RequestWebinarOnClick(ActionEvent event) {
        try {
            loadFXML("Program.fxml");
        } catch (IOException e) {
            e.printStackTrace();           
        }
    }

    private void loadFXML(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = loader.load();
        dashboardAnchorPane.getChildren().setAll(root);
    }
}