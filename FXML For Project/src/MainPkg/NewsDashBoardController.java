/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class NewsDashBoardController implements Initializable {

    @FXML
    private ComboBox<LocalDate> NewsDatePicker;
    @FXML private TextArea NewsDashBoardTextArea;
    
    private final NewsFileHandler newsFileHandler = new NewsFileHandler();
    private ArrayList<News> newsList;

    
    @Override public void initialize(URL url, ResourceBundle rb) 
    {
        loadAvailableDates();
    }    
    private void loadAvailableDates() 
    { 
        newsList = newsFileHandler.loadNewsListFromFile("News.bin");
        ArrayList<LocalDate> dates = new ArrayList<>();
        for (News news : newsList) 
        {
            LocalDate date = news.getDate();
            if (!dates.contains(date)) 
            {
                dates.add(date);
            }
        }        
        NewsDatePicker.getItems().addAll(dates);
    }

    @FXML
    private void ShowNewsOnClick(ActionEvent event) 
    {
        LocalDate selectedDate = NewsDatePicker.getValue();

        if (selectedDate != null) 
        {
            StringBuilder newsToShow = new StringBuilder();
            for (News news : newsList) 
            {
                if (news.getDate().equals(selectedDate)) 
                {
                    newsToShow.append("Headline: ").append(news.getHeadline()).append("\n")
                              .append("Date: ").append(news.getDate()).append("\n")
                              .append("Description: ").append(news.getDescription())
                              .append("\n").append("......").append("\n");
                }
            }
            NewsDashBoardTextArea.setText(newsToShow.toString());
        }
    }
    
    
}
