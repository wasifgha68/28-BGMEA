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
public class GarmentListSceneController implements Initializable {

    @FXML
    private TableColumn<GarmentList, String> nameTable;
    @FXML
    private TableColumn<GarmentList, String> typeTable;
    @FXML
    private TableColumn<GarmentList, String> remarkTable;
    @FXML
    private TableView<GarmentList> garmentListTable;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField remarkTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeTable.setCellValueFactory(new PropertyValueFactory<>("type"));
        remarkTable.setCellValueFactory(new PropertyValueFactory<>("remark"));
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("GarmentList.bin"))) {
            ArrayList<GarmentList> items = (ArrayList<GarmentList>) ois.readObject();
            garmentListTable.getItems().setAll(items);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }    

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        GarmentList selectedItem = garmentListTable.getSelectionModel().getSelectedItem();
        garmentListTable.getItems().remove(selectedItem);
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<GarmentList> tableData = new ArrayList<>();
            for (GarmentList item : garmentListTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("GarmentList.bin"))) {
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
        String type = typeTextField.getText();
        String remark = remarkTextField.getText();

        GarmentList newItem = new GarmentList(name, type, remark);

        garmentListTable.getItems().add(newItem);

        nameTextField.clear();
        typeTextField.clear();
        remarkTextField.clear();
    }
    
}
