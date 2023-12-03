/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template

package MainPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RawMaterialController implements Initializable {

    @FXML
    private TableView<RRawMaterial> RawMaterialTableView;
    @FXML
    private TableColumn<RRawMaterial,Integer> RawMaterialIDcolTB;
    @FXML
    private TableColumn<RRawMaterial,String> MaterialNameColTB;
    @FXML
    private TableColumn<RRawMaterial,Double> QuantityColTB;
    @FXML
    private TableColumn<RRawMaterial,Double> UnitPriceColTB;
    @FXML
    private TableColumn<RRawMaterial,Double> TotalPriceColTB;
    @FXML
    private TextField RawMaterialIDTextField;
    @FXML
    private TextField MaterialNameTextField;
    @FXML
    private TextField SupplierTextField;
    @FXML
    private TextField QuantityTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        RawMaterialIDcolTB.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        RawMaterialIDcolTB.setCellValueFactory(new PropertyValueFactory<>("rawMaterialID"));
        DescriptionColTB.setCellValueFactory(new PropertyValueFactory<>("description"));
        StatusColTB.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
    }    

    @FXML
    private void ModifyDetailsOnclick(ActionEvent event) {
    }

    @FXML
    private void DeleteItemOnClick(ActionEvent event) {
    }

    @FXML
    private void GenerateRawMaterialOnClick(ActionEvent event) {
    }

    @FXML
    private void ConfirmOnClick(ActionEvent event) {
    }
    
}*/
