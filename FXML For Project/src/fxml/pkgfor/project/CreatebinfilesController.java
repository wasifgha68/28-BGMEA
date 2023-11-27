/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CreatebinfilesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createBinOnMouseClicked(ActionEvent event) {
        List<CreateSampleOrder> sampleOrder = new ArrayList<>();
        sampleOrder.add(new CreateSampleOrder( 11235, 100, "Wool Roll"));
        sampleOrder.add(new CreateSampleOrder(12341, 200, "Silk Roll"));
        sampleOrder.add(new CreateSampleOrder(12522, 150, "Cotton Roll"));

        // Serialize the list to a .bin file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SampleOrder.bin"))) {
            oos.writeObject(sampleOrder);
            System.out.println("Data file created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
