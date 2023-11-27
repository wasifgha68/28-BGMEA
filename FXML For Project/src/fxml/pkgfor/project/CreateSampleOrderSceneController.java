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
public class CreateSampleOrderSceneController implements Initializable {

    @FXML
    private TextField catalogNumberTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField itemNameTextField;
    @FXML
    private TableView<CreateSampleOrder> orderTable;
    @FXML
    private TableColumn<CreateSampleOrder, String> catalogTable;
    @FXML
    private TableColumn<CreateSampleOrder, String> qualityTable;
    @FXML
    private TableColumn<CreateSampleOrder, String> itemNameTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        catalogTable.setCellValueFactory(new PropertyValueFactory<>("catalogNum"));
        qualityTable.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        itemNameTable.setCellValueFactory(new PropertyValueFactory<>("itemName"));
    }    

    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        int catalogNumber = Integer.parseInt(catalogNumberTextField.getText());
        int quantity = Integer.parseInt(quantityTextField.getText());
        String itemName = itemNameTextField.getText();

        CreateSampleOrder newItem = new CreateSampleOrder(catalogNumber, quantity, itemName);

        orderTable.getItems().add(newItem);

        catalogNumberTextField.clear();
        quantityTextField.clear();
        itemNameTextField.clear();
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<CreateSampleOrder> tableData = new ArrayList<>();
            for (CreateSampleOrder item : orderTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SampleOrder.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        CreateSampleOrder selectedItem = orderTable.getSelectionModel().getSelectedItem();
        orderTable.getItems().remove(selectedItem);
    }

    @FXML
    private void openOrderOnMouseClicked(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SampleOrder.bin"))) {
            ArrayList<CreateSampleOrder> items = (ArrayList<CreateSampleOrder>) ois.readObject();
            orderTable.getItems().setAll(items);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
