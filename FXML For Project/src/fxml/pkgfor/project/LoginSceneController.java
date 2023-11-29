/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField empIDTextField;
    @FXML
    private ComboBox<String> deptComboBox;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label alertLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] dept = {"Administration", "FactoryManager", "ProductionSupervisor", "QualityControlInspector", "ShippingandLogisticsCoordinator", "SalesRepresentative", "Accountant", "HumanResourcesManager"};

        deptComboBox.getItems().setAll(dept);
    }

    @FXML
    private void loginOnMouseClicked(ActionEvent event) throws IOException {
        int ID = Integer.parseInt(empIDTextField.getText());
        String password = passwordField.getText();
        String dept = deptComboBox.getSelectionModel().getSelectedItem();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dept+"LoginInfo.bin"))){
            List<Login> list = (List<Login>) ois.readObject();
            ois.close();
            
            for (Login login : list) {
                if (login.getId() == ID && login.getPass().equals(password)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(dept+"Dashboard.fxml"));
                    Stage stage = (Stage) empIDTextField.getScene().getWindow();
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                }
            }
        } catch (Exception e) {
            alertLabel.setText("Incorrect ID or password. Try again!");
        }
    }

}
