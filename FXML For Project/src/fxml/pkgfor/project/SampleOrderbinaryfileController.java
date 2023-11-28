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
        List<FabMatList> dataList = new ArrayList<>();
        dataList.add(new FabMatList("Silk", "Fab", 150, 5000, "Ready to be used"));
        dataList.add(new FabMatList("Buttons", "Mat", 6000, 750, "Ready to be used"));
        dataList.add(new FabMatList("Cotton", "Fab", 110, 2000, "Need inspecting"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FabMatList.bin"))) {
            oos.writeObject(dataList);
            System.out.println("Cost Report.bin file created successfully.");
        } catch (Exception e) {

        }
    }
    
}
