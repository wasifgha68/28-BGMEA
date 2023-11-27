/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class SampleOrderbinaryfileController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void createBinFile(ActionEvent event) {
        List<Jobs> dataList = new ArrayList<>();
        dataList.add(new Jobs(7641, "Production", "on duty"));
        dataList.add(new Jobs(8879, "Maintanence", "free to assign"));
        dataList.add(new Jobs(9855, "Inspection", "off site"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Jobs.bin"))) {
            oos.writeObject(dataList);
            System.out.println("Cost Report.bin file created successfully.");
        } catch (Exception e) {

        }
    }
    
}
