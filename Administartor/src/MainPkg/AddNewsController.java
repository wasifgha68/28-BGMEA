/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MainPkg;

import MainPkg.News;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AddNewsController implements Initializable {

    @FXML private TextField HeadLinesTextArea;
    @FXML private DatePicker NewsDatePicker;
    @FXML private TextArea DescriptionTextArea;
    @FXML private TableView<NewsTableView> NewsTableView;
    @FXML private TableColumn<NewsTableView, LocalDate> NewDateColTB;
    @FXML private TableColumn<NewsTableView, String> HeadLinesColTB;
    @FXML private TableColumn<NewsTableView, String> NewsStatusTB;
    @FXML private RadioButton ModifyNewsRB;
    @FXML private RadioButton AddNewRB;
    
    NewsFileHandler newsFileHandler = new NewsFileHandler();
    private String filePath = "News.bin";
    
    private ToggleGroup toggleGroup;
    private ObservableList<NewsTableView> observableNewsList = FXCollections.observableArrayList();
    private ArrayList<News> newsList = new ArrayList<>();
    
    @Override public void initialize(URL url, ResourceBundle rb) 
    {
        NewDateColTB.setCellValueFactory(new PropertyValueFactory<>("date"));
        HeadLinesColTB.setCellValueFactory(new PropertyValueFactory<>("headline"));
        NewsStatusTB.setCellValueFactory(new PropertyValueFactory<>("status"));
        NewsTableView.setItems(observableNewsList);
        toggleGroup = new ToggleGroup();
        AddNewRB.setToggleGroup(toggleGroup);
        ModifyNewsRB.setToggleGroup(toggleGroup);
       
    }    

    
    @FXML private void AddNewsOnClick(ActionEvent event) 
    {
        String headline = HeadLinesTextArea.getText();
        LocalDate date = NewsDatePicker.getValue();
        String description = DescriptionTextArea.getText();
        
        if (headline.isEmpty() || date == null || description.isEmpty()) 
        {
            Alert ErrorAlert = new Alert(Alert.AlertType.INFORMATION);
            ErrorAlert.setTitle("Error");
            ErrorAlert.setHeaderText(null);
            ErrorAlert.setContentText("Please Fill in the field" );
            ErrorAlert.showAndWait();
        }
        newsList = newsFileHandler.loadNewsListFromFile(filePath);
        if (AddNewRB.isSelected()) 
        {
            boolean exists = newsList.stream().anyMatch(news -> news.getHeadline().equals(headline) && news.getDate().equals(date));
            if (!exists) 
            {
                News newNews = new News(headline, date, "New");
                newNews.setDescription(description);
                newsList.add(newNews);
                newsFileHandler.saveNewsListToFile(newsList, filePath);
                
                Alert SuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                SuccessAlert.setTitle("Success");
                SuccessAlert.setHeaderText(null);
                SuccessAlert.setContentText("News added successfully!" );
                SuccessAlert.showAndWait();
            } 
            else 
            {
                Alert ErrorAlert = new Alert(Alert.AlertType.WARNING);
                ErrorAlert.setTitle("Warning");
                ErrorAlert.setHeaderText(null);
                ErrorAlert.setContentText("News with the same headline and date already exists." );
                ErrorAlert.showAndWait();
                
            }
        }
        else if (ModifyNewsRB.isSelected()) 
        {
            boolean existsForModification = newsList.stream().anyMatch(news -> news.getHeadline().equals(headline) && news.getDate().equals(date));
            if (existsForModification) 
            {
                newsList.stream().filter(news -> news.getHeadline().equals(headline) && news.getDate().equals(date)).forEach(news -> 
                {
                        news.setDescription(description);
                });
                newsFileHandler.saveNewsListToFile(newsList, filePath);
                Alert SuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                SuccessAlert.setTitle("Success");
                SuccessAlert.setHeaderText(null);
                SuccessAlert.setContentText("News modified successfully!" );
                SuccessAlert.showAndWait();
            } 
            else 
            {
                Alert ErrorAlert = new Alert(Alert.AlertType.WARNING);
            ErrorAlert.setTitle("Warning");
            ErrorAlert.setHeaderText(null);
            ErrorAlert.setContentText("News to modify does not exist." );
            ErrorAlert.showAndWait();
            }
        }
    }
    private void updateObservableNewsList() 
    {
        observableNewsList.clear(); 
        for (News news : newsList) 
        {
            NewsTableView newsTableViewItem = new NewsTableView(news.getHeadline(), news.getDate(), news.getStatus());
            observableNewsList.add(newsTableViewItem); 
        }
        NewsTableView.setItems(observableNewsList);
    }

    

       
    


    @FXML private void ViewNewsOnClick(ActionEvent event) 
    {
        newsList = newsFileHandler.loadNewsListFromFile(filePath);
        updateObservableNewsList();
        
    }
   
    
    @FXML private void ConfirmNewsOnClick(ActionEvent event) 
    {
        newsList = newsFileHandler.loadNewsListFromFile(filePath);
        newsList = newsFileHandler.loadNewsListFromFile(filePath);
        Alert SuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                SuccessAlert.setTitle("Success");
                SuccessAlert.setHeaderText(null);
                SuccessAlert.setContentText("News added to News.bin file" );
                SuccessAlert.showAndWait();

    }

    @FXML
    private void BacktoNewsDashBoardOnClick(ActionEvent event)
    {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewsDashBoard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }

    

    
        
    
    
}
