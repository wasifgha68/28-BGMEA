/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import MainPkg.AdministratorDashBoardController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ProductionSupervisorDashboardController implements Initializable {

    @FXML
    private Label nameTextField;
    @FXML
    private AnchorPane dashboardAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Load the default scene when initializing
            loadFXML("FactoryManagerDatacBackup.fxml");
        } catch (IOException ex) {
            Logger.getLogger(AdministratorDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    @FXML
    private void logOutOnMouseClicked(ActionEvent event) {
    }

    @FXML
    private void DataBackUPOnClick(ActionEvent event) {
        try {
            loadFXML("SupplierProfile.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void SupplierListOnClicked(ActionEvent event) {
        try {
            loadFXML("Vendor.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void VendorListOnMouseClicked(ActionEvent event) {
    }
    private void loadFXML(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        AnchorPane pane = loader.load();
        dashboardAnchorPane.getChildren().setAll(pane); 
    }
    
}
