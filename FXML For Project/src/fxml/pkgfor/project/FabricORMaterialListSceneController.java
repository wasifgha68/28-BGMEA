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
public class FabricORMaterialListSceneController implements Initializable {

    @FXML
    private TableColumn<FabMatList, String> itemTable;
    @FXML
    private TableColumn<FabMatList, String> unitTable;
    @FXML
    private TableColumn<FabMatList, Double> totalPriceTable;
    @FXML
    private TableColumn<FabMatList, String> notesTable;
    @FXML
    private TableView<FabMatList> fabMatTable;
    @FXML
    private TableColumn<FabMatList, String> typeTable;
    @FXML
    private TextField itemTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField unitTextFIeld;
    @FXML
    private TextField totalTextField;
    @FXML
    private TextField notesTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        itemTable.setCellValueFactory(new PropertyValueFactory<>("item"));
        typeTable.setCellValueFactory(new PropertyValueFactory<>("type"));
        unitTable.setCellValueFactory(new PropertyValueFactory<>("unit"));
        totalPriceTable.setCellValueFactory(new PropertyValueFactory<>("total"));
        notesTable.setCellValueFactory(new PropertyValueFactory<>("notes"));
    }    

    @FXML
    private void loadOnMouseClicked(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FabMatList.bin"))) {
            ArrayList<FabMatList> items = (ArrayList<FabMatList>) ois.readObject();
            fabMatTable.getItems().setAll(items);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<FabMatList> tableData = new ArrayList<>();
            for (FabMatList item : fabMatTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FabMatList.bin"))) {
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
        String item = itemTextField.getText();
        String type = typeTextField.getText();
        int unit = Integer.parseInt(unitTextFIeld.getText());
        double total = Double.parseDouble(totalTextField.getText());
        String notes = notesTextField.getText();

        FabMatList newItem = new FabMatList(item, type, unit, total, notes);

        fabMatTable.getItems().add(newItem);

        itemTextField.clear();
        typeTextField.clear();
        unitTextFIeld.clear();
        totalTextField.clear();
        notesTextField.clear();
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        FabMatList selectedItem = fabMatTable.getSelectionModel().getSelectedItem();
        fabMatTable.getItems().remove(selectedItem);
    }
    
}
