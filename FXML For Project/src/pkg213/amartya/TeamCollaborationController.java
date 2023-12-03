/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg213.amartya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;


public class TeamCollaborationController implements Initializable {

    @FXML
    private ListView<?> teamMembersList;
    @FXML
    private TextArea messageBoard;
    @FXML
    private TextArea messageInput;
    @FXML
    private Button postMessageButton;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePostMessageAction(ActionEvent event) {
    }
    
}
