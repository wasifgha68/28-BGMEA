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
public class QualityControlReportSceneController implements Initializable {

    @FXML
    private TableColumn<QualityControlReport, String> batchTable;
    @FXML
    private TableColumn<QualityControlReport, String> descriptionTable;
    @FXML
    private TableColumn<QualityControlReport, String> statusTable;
    @FXML
    private TableColumn<QualityControlReport, String> notesTable;
    @FXML
    private TableView<QualityControlReport> QCRTable;
    @FXML
    private TextField batchNoTextField;
    @FXML
    private TextField descTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField notesTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        batchTable.setCellValueFactory(new PropertyValueFactory<>("batchNum"));
        descriptionTable.setCellValueFactory(new PropertyValueFactory<>("description"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("status"));
        notesTable.setCellValueFactory(new PropertyValueFactory<>("notes"));
    }    

    @FXML
    private void loadOnMouseClicked(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("QualityControlReport.bin"))) {
            List<QualityControlReport> entries = (List<QualityControlReport>) ois.readObject();
            QCRTable.getItems().setAll(entries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void addOnMouseClicked(ActionEvent event) {
        int batchNum = Integer.parseInt(batchNoTextField.getText());
        String description = descTextField.getText();
        String status = statusTextField.getText();
        String notes = notesTextField.getText();

        QualityControlReport newInstance = new QualityControlReport(batchNum, description, status, notes);

        QCRTable.getItems().add(newInstance);
    }

    @FXML
    private void deleteOnMouseClicked(ActionEvent event) {
        QualityControlReport selectedItem = QCRTable.getSelectionModel().getSelectedItem();
        QCRTable.getItems().remove(selectedItem);
    }

    @FXML
    private void saveOnMouseClicked(ActionEvent event) {
        try {
            List<QualityControlReport> tableData = new ArrayList<>();
            for (QualityControlReport item : QCRTable.getItems()) {
                tableData.add(item);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("QualityControlReport.bin"))) {
                oos.writeObject(tableData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
