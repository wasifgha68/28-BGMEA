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
public class InventoryRecordSceneController implements Initializable {

    @FXML
    private TableColumn<InventoryRecord, String> nameTable;
    @FXML
    private TableColumn<InventoryRecord, String> unitTable;
    @FXML
    private TableColumn<InventoryRecord, Double> inventoryValueTable;
    @FXML
    private TableView<InventoryRecord> invRecTable;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField unitTextField;
    @FXML
    private TextField invValueTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitTable.setCellValueFactory(new PropertyValueFactory<>("unit"));
        inventoryValueTable.setCellValueFactory(new PropertyValueFactory<>("invVal"));
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InventoryRecord.bin"))) {
            ArrayList<InventoryRecord> items = (ArrayList<InventoryRecord>) ois.readObject();
            invRecTable.getItems().setAll(items);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }    


    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<InventoryRecord> tableData = new ArrayList<>();
            for (InventoryRecord item : invRecTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InventoryRecord.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                System.out.println("Exception occured " + e);
            }
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        String name = nameTextField.getText();
        int unit = Integer.parseInt(unitTextField.getText());
        double invVal = Double.parseDouble(invValueTextField.getText());

        InventoryRecord newItem = new InventoryRecord(name, unit, invVal);

        invRecTable.getItems().add(newItem);

        nameTextField.clear();
        unitTextField.clear();
        invValueTextField.clear();
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        InventoryRecord selectedItem = invRecTable.getSelectionModel().getSelectedItem();
        invRecTable.getItems().remove(selectedItem);
    }
    
}
