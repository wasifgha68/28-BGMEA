/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CreateWorkmanshipReportSceneController implements Initializable {

    @FXML
    private TextArea reportTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openReportOnMouseClicked(ActionEvent event) {
        File file = new File("WorkmanshipReportTemplate.bin");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            String content = new String(data, "UTF-8");
            reportTextArea.setText(content);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    @FXML
    private void saveReportOnMouseClicked(ActionEvent event) {
        File file = new File("CompleteWorkmanshipReport.bin");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] content = reportTextArea.getText().getBytes("UTF-8");
            fos.write(content);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }
    
}
