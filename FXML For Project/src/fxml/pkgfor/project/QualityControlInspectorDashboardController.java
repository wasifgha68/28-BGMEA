/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class QualityControlInspectorDashboardController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private AnchorPane dashboardAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logoutOnMouseClicked(ActionEvent event) {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("ProductionSupervisorDashboard.fxml"));

            MenuItem menuItem = (MenuItem) event.getSource();
            Stage stage = null;
            javafx.scene.Node source = (javafx.scene.Node) menuItem.getParentPopup().getOwnerNode();
            if (source != null) {
                stage = (Stage) source.getScene().getWindow();
            }
            if (stage != null) {
                stage.setScene(new Scene(loginRoot));
                stage.sizeToScene();
                stage.show();
            }
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void dashboardOnMouseClicked(ActionEvent event) {
        dashboardAnchorPane.getChildren().clear();
    }

    @FXML
    private void garmentListOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("GarmentListScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void fabMatListOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("FabricORMaterialListScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void inspectionReportOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("CreateInspectionReportScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void worksmanshipReportOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("CreateWorkmanshipReportScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void complianceStatusOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("UpdateComplianceStatusScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
           System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void trainingMatOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("TrainingMaterialScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void sampleOrderOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("CreateSampleOrderScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void QRCReportOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("QualityControlReportScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (IOException e) {
            System.out.println("Exception occured " + e);
        }
    }
    
}
