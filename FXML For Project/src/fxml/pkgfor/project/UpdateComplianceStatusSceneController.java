/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class UpdateComplianceStatusSceneController implements Initializable {

    @FXML
    private TableColumn<UpdateComplianceStatus, String> itemTable;
    @FXML
    private TableColumn<UpdateComplianceStatus, String> statusTable;
    @FXML
    private TableColumn<UpdateComplianceStatus, String> remarksTable;
    @FXML
    private TableView<UpdateComplianceStatus> complianceTable;
    @FXML
    private TextField itemTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField remarksTextField;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemTable.setCellValueFactory(new PropertyValueFactory<>("item"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("status"));
        remarksTable.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ComplianceStatus.bin"))) {
            ArrayList<UpdateComplianceStatus> items = (ArrayList<UpdateComplianceStatus>) ois.readObject();
            complianceTable.getItems().setAll(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<UpdateComplianceStatus> tableData = new ArrayList<>();
            for (UpdateComplianceStatus item : complianceTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ComplianceStatus.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        String item = itemTextField.getText();
        String status = statusTextField.getText();
        String remarks = remarksTextField.getText();

        UpdateComplianceStatus newItem = new UpdateComplianceStatus(item, status, remarks);

        complianceTable.getItems().add(newItem);

        itemTextField.clear();
        statusTextField.clear();
        remarksTextField.clear();
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        UpdateComplianceStatus selectedItem = complianceTable.getSelectionModel().getSelectedItem();
        complianceTable.getItems().remove(selectedItem);
    }
    
}
