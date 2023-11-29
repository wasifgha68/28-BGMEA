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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CostReportSceneController implements Initializable {

    @FXML
    private TableView<CostReport> costTable;
    @FXML
    private TableColumn<CostReport, LocalDate> dateTable;
    @FXML
    private TableColumn<CostReport, String> itemNameTable;
    @FXML
    private TableColumn<CostReport, Double> totalSpentTable;
    @FXML
    private TableColumn<CostReport, String> notesTable;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TextField itemNameTextField;
    @FXML
    private TextField totalSpentTextField;
    @FXML
    private TextField notesTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        itemNameTable.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        totalSpentTable.setCellValueFactory(new PropertyValueFactory<>("totalSpent"));
        notesTable.setCellValueFactory(new PropertyValueFactory<>("notes"));
    }    

    @FXML
    private void loadCROnMouseClicked(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CostReport.bin"))) {
            List<CostReport> entries = (List<CostReport>) ois.readObject();
            costTable.getItems().setAll(entries);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void saveCROnMouseClicked(ActionEvent event) {
        try {
            List<CostReport> tableData = new ArrayList<>();
            for (CostReport item : costTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CostReport.bin"))) {
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
        LocalDate date = dateDatePicker.getValue();
        String itemName = itemNameTextField.getText();
        double totalSpent = Double.parseDouble(totalSpentTextField.getText());
        String notes = notesTextField.getText();

        CostReport newInstance = new CostReport(date, itemName, totalSpent, notes);

        costTable.getItems().add(newInstance);
    }

    @FXML
    private void deleteSelectedOnMouseClicked(ActionEvent event) {
        CostReport selectedItem = costTable.getSelectionModel().getSelectedItem();
        costTable.getItems().remove(selectedItem);

    }
    
}
