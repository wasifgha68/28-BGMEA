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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateProductionPlanSceneController implements Initializable {

    @FXML
    private TableColumn<UpdateProductionPlan, String> prodNameTable;
    @FXML
    private TableColumn<UpdateProductionPlan, String> objectiveTable;
    @FXML
    private TableColumn<UpdateProductionPlan, String> empIDTable;
    @FXML
    private TextField prodNameTextField;
    @FXML
    private TextField objectiveTextField;
    @FXML
    private TextField employeeIDTextField;
    @FXML
    private TableView<UpdateProductionPlan> prodPlanTable;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prodNameTable.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        objectiveTable.setCellValueFactory(new PropertyValueFactory<>("objective"));
        empIDTable.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        
    }    

    @FXML
    private void loadPlanOnMouseClicked(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ProductionPlan.bin"))) {
            ArrayList<UpdateProductionPlan> items = (ArrayList<UpdateProductionPlan>) ois.readObject();
            prodPlanTable.getItems().setAll(items);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<UpdateProductionPlan> tableData = new ArrayList<>();
            for (UpdateProductionPlan item : prodPlanTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ProductionPlan.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                System.out.println("Exception occured " + e);
            }
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void addInstanceOnMouseClicked(ActionEvent event) {
        String prodName = prodNameTextField.getText();
        String objective = objectiveTextField.getText();
        int employeeID = Integer.parseInt(employeeIDTextField.getText());

        UpdateProductionPlan newItem = new UpdateProductionPlan(prodName, objective, employeeID);

        prodPlanTable.getItems().add(newItem);

        prodNameTextField.clear();
        objectiveTextField.clear();
        employeeIDTextField.clear();
    }

    @FXML
    private void deleteInstanceOnMouseClicked(ActionEvent event) {
        UpdateProductionPlan selectedItem = prodPlanTable.getSelectionModel().getSelectedItem();
        prodPlanTable.getItems().remove(selectedItem);
    }
    
}
