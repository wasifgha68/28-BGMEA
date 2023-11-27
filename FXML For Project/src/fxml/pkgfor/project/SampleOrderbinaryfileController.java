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
        List<QualityControlReport> dataList = new ArrayList<>();
        dataList.add(new QualityControlReport(764182, "50 Jeans", "accepted", "no notes"));
        dataList.add(new QualityControlReport(887913, "40 Shirts", "rejected", "9 defective need to be sent back"));
        dataList.add(new QualityControlReport(985524, "80 T-shirts", "accepted", "2 defective rest fine"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("QualityControlReport.bin"))) {
            oos.writeObject(dataList);
            System.out.println("Cost Report.bin file created successfully.");
        } catch (Exception e) {

        }
    }
    
}
