/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml.pkgfor.project;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IncidentReportSceneController implements Initializable {

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
    private void loadReportOnMouseClicked(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIN files (*.bin)", "*.bin");
        fc.getExtensionFilters().add(extFilter);
        fc.setInitialDirectory(new File(System.getProperty("user.dir")));
        File file = fc.showOpenDialog(null);

        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] data = new byte[(int) file.length()];
                fis.read(data);
                String content = new String(data, "UTF-8");
                reportTextArea.setText(content);
            } catch (Exception e) {
                System.out.println("Exception occured " + e);
            }
        }
    }

    @FXML
    private void closeOnMouseClicked(ActionEvent event) {
        reportTextArea.clear();
    }
    
}
