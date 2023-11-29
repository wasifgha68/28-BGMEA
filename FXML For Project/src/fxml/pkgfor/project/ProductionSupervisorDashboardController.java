/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProductionSupervisorDashboardController implements Initializable {

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
    private void dashboardOnMouseClicked(ActionEvent event) {
        dashboardAnchorPane.getChildren().clear();
    }

    @FXML
    private void assignJobOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("JobsScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void jobProgressOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("JobProgressScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }        
    }

    @FXML
    private void scheduleOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("ReviseScheduleScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void reportOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("CreateReportScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void productionPlanOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("UpdateProductionPlanScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void inventoryOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("InventoryRecordScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void costReportOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("CostReportScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void incidentReportOnMouseClicked(ActionEvent event) {
        try {
            Parent dash = FXMLLoader.load(getClass().getResource("IncidentReportScene.fxml"));

            dashboardAnchorPane.getChildren().setAll(dash);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void logOutOnMouseClicked(ActionEvent event) {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));

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
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }

    }
    
}
