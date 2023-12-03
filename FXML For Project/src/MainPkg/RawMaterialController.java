

package MainPkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RawMaterialController implements Initializable {

    @FXML
    private TableView<RawMaterial> RawMaterialTableView;
    @FXML
    private TableColumn<RawMaterial,Integer> RawMaterialIDcolTB;
    @FXML
    private TableColumn<RawMaterial,String> MaterialNameColTB;
    @FXML
    private TableColumn<RawMaterial,Double> QuantityColTB;
    @FXML
    private TableColumn<RawMaterial,Double> UnitPriceColTB;
    @FXML
    private TableColumn<RawMaterial,Double> TotalPriceColTB;
    @FXML
    private TextField RawMaterialIDTextField;
    @FXML
    private TextField MaterialNameTextField;
    @FXML
    private TextField SupplierTextField;
    @FXML
    private TextField QuantityTextField;
    @FXML
    private TextField UnitPriceTextField;
    
    private ObservableList<RawMaterial>rawmaterialList = FXCollections.observableArrayList();
    
    private SupplierFileHandler fileHandler = new SupplierFileHandler();
    private RawMaterialFileHandler RawfileHandler = new RawMaterialFileHandler();
    private String filePath = "RawmaterialDetails.bin";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        MaterialNameColTB.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        RawMaterialIDcolTB.setCellValueFactory(new PropertyValueFactory<>("rawMaterialID"));
        QuantityColTB.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        UnitPriceColTB.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        TotalPriceColTB.setCellValueFactory(new PropertyValueFactory<>("totalPrice")); 
        ArrayList<RawMaterial> loadedMaterials = RawfileHandler.loadRawMaterialListFromFile(filePath);
    if (loadedMaterials != null) {
        rawmaterialList.addAll(loadedMaterials);
        RawMaterialTableView.setItems(rawmaterialList);
    }
    }
    private void addRawMaterial(ActionEvent event) {
    String rawMaterialIDText = RawMaterialIDTextField.getText();
    String materialName = MaterialNameTextField.getText();
    String quantityText = QuantityTextField.getText();
    String unitPriceText = UnitPriceTextField.getText();
    String supplierName = SupplierTextField.getText();

    boolean isValidInput = true;

    if (rawMaterialIDText.isEmpty() || materialName.isEmpty() || quantityText.isEmpty() || unitPriceText.isEmpty() || supplierName.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Information");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all fields.");
        alert.showAndWait();
        isValidInput = false;
    } else {
        try {
            int rawMaterialID = Integer.parseInt(rawMaterialIDText);
            double quantity = Double.parseDouble(quantityText);
            double unitPrice = Double.parseDouble(unitPriceText);

            // Load the supplier list from the file
            SupplierFileHandler fileHandler = new SupplierFileHandler(); 
            ArrayList<SupplierTableView> supplierList = fileHandler.loadSupplierListFromFile("supplierDetails.bin");

                        boolean supplierExists = supplierList.stream()
                    .anyMatch(supplier -> supplier.getName().equalsIgnoreCase(supplierName));

            if (!supplierExists) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Supplier Not Found");
                alert.setHeaderText(null);
                alert.setContentText("Supplier with name '" + supplierName + "' does not exist.");
                alert.showAndWait();
                isValidInput = false;
            }

            if (isValidInput && !isMaterialAlreadyExists(rawMaterialID)) {
                RawMaterial newMaterial = new RawMaterial(rawMaterialID, supplierName, materialName, quantity, unitPrice);
                
                RawMaterialIDTextField.clear();
                MaterialNameTextField.clear();
                QuantityTextField.clear();
                UnitPriceTextField.clear();
                SupplierTextField.clear();
                double calculatedTotalPrice = newMaterial.calculateTotalPrice(); 
                newMaterial.setTotalPrice(calculatedTotalPrice);
                rawmaterialList.add(newMaterial);
                showAlert("Material added successfully");
                saveToBinFile();
            } else if (isValidInput) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duplicate Material");
                alert.setHeaderText(null);
                alert.setContentText("Material with ID " + rawMaterialID + " already exists.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numeric values for ID, Quantity, and Unit Price.");
            alert.showAndWait();
            isValidInput = false;
        }
    }
    }


    
    private boolean isMaterialAlreadyExists(int materialID) 
    {
        for (RawMaterial material : rawmaterialList) 
        {
            if (material.getRawMaterialID() == materialID) 
            {
                return true;
            } 
        }
        return false; 
    }
    
    @FXML private void ModifyDetailsOnclick(ActionEvent event) {
    String rawMaterialIDText = RawMaterialIDTextField.getText();
    String materialName = MaterialNameTextField.getText();
    String quantityText = QuantityTextField.getText();
    String unitPriceText = UnitPriceTextField.getText();
    String supplierName = SupplierTextField.getText();

    if (rawMaterialIDText.isEmpty() || materialName.isEmpty() || quantityText.isEmpty() || unitPriceText.isEmpty() || supplierName.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Information");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all fields.");
        alert.showAndWait();
    } else {
        try {
            int rawMaterialID = Integer.parseInt(rawMaterialIDText);
            double quantity = Double.parseDouble(quantityText);
            double unitPrice = Double.parseDouble(unitPriceText);

            SupplierFileHandler fileHandler = new SupplierFileHandler();
            ArrayList<SupplierTableView> supplierList = fileHandler.loadSupplierListFromFile("supplierDetails.bin");

            boolean supplierExists = supplierList.stream()
                    .anyMatch(supplier -> supplier.getName().equalsIgnoreCase(supplierName));

            if (!supplierExists) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Supplier Not Found");
                alert.setHeaderText(null);
                alert.setContentText("Supplier with name '" + supplierName + "' does not exist.");
                alert.showAndWait();
            } else {
                RawMaterial existingMaterial = findMaterialByID(rawMaterialID);
                if (existingMaterial != null) {
                    if (!existingMaterial.getMaterialName().equalsIgnoreCase(materialName)
                            || existingMaterial.getRawMaterialID() != rawMaterialID) {
                        showAlert("Cannot modify Material ID or Name.");
                        return;
                    }

                    existingMaterial.setMaterialName(materialName);
                    existingMaterial.setQuantity(quantity);
                    existingMaterial.setUnitPrice(unitPrice);
                    existingMaterial.setSupplierName(supplierName);

                    showAlert("Material modified successfully");
                    rawmaterialList.remove(existingMaterial);

    // Update total price and re-add the modified material
    double calculatedTotalPrice = existingMaterial.calculateTotalPrice(); 
    existingMaterial.setTotalPrice(calculatedTotalPrice);
    rawmaterialList.add(existingMaterial);

    // Refresh TableView to reflect changes
    RawMaterialTableView.setItems(null);
    RawMaterialTableView.layout();
    RawMaterialTableView.setItems(rawmaterialList);
    saveToBinFile();
                    
                    

                    
                } else {
                    showAlert("Material with ID " + rawMaterialID + " doesn't exist.");
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numeric values for ID, Quantity, and Unit Price.");
            alert.showAndWait();
        }
    }


    }



    
    
    private RawMaterial findMaterialByID(int materialID) 
    {
        for (RawMaterial material : rawmaterialList) 
        {
            if (material.getRawMaterialID() == materialID) 
            {
                return material; 
            }
        }
        return null; 
    }
    private void showAlert(String message) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
        @FXML private void DeleteItemOnClick(ActionEvent event) {
            String rawMaterialIDText = RawMaterialIDTextField.getText();
    String materialName = MaterialNameTextField.getText();
    String quantityText = QuantityTextField.getText();
    String unitPriceText = UnitPriceTextField.getText();
    String supplierName = SupplierTextField.getText();

    if (rawMaterialIDText.isEmpty() || materialName.isEmpty() || quantityText.isEmpty() || unitPriceText.isEmpty() || supplierName.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Information");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all fields.");
        alert.showAndWait();
    } else {
        try {
            int rawMaterialID = Integer.parseInt(rawMaterialIDText);

            SupplierFileHandler fileHandler = new SupplierFileHandler();
            ArrayList<SupplierTableView> supplierList = fileHandler.loadSupplierListFromFile("supplierDetails.bin");

            boolean supplierExists = supplierList.stream()
                    .anyMatch(supplier -> supplier.getName().equalsIgnoreCase(supplierName));

            if (!supplierExists) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Supplier Not Found");
                alert.setHeaderText(null);
                alert.setContentText("Supplier with name '" + supplierName + "' does not exist.");
                alert.showAndWait();
            } else {
                RawMaterial materialToRemove = findMaterialByID(rawMaterialID);
                if (materialToRemove != null) {
                    rawmaterialList.remove(materialToRemove);
                    showAlert("Material with ID " + rawMaterialID + " has been deleted.");

                    
                    saveToBinFile();
                } else {
                    showAlert("Material with ID " + rawMaterialID + " doesn't exist.");
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid Raw Material ID (numeric value).");
            alert.showAndWait();
        }
    }
}





    @FXML
    private void AddItemOnClick(ActionEvent event) 
    {
        addRawMaterial(event);
        saveToBinFile();
        
    }
    private void saveToBinFile() 
    {
        ArrayList<RawMaterial> materialArrayList = new ArrayList<>(rawmaterialList);
        RawfileHandler.saveRawMaterialListToFile(materialArrayList, filePath);
        showAlert("Information saved to bin.");
    }

    @FXML
    private void GenerateRawMaterialOnClick(ActionEvent event) 
    {
        RawMaterialTableView.setItems(rawmaterialList);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WELL THE TABLE WAS ALREADY FILLED");
            alert.setHeaderText(null);
            alert.setContentText("It saves it again, I call it code friction :)");
            alert.showAndWait();
    }

    @FXML
    private void ConfirmOnClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCESS");
            alert.setHeaderText("it just an random Alert");
            alert.setContentText("YOU MADE IT ");
            alert.showAndWait();

    }

}
