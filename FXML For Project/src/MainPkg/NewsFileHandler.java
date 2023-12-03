package MainPkg;
import java.io.*;
import java.util.ArrayList;

public class NewsFileHandler 
{
    public ArrayList<News> loadNewsListFromFile(String filePath) 
    {
        ArrayList<News> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) 
        {
            loadedList = (ArrayList<News>) objectIn.readObject();
            System.out.println("News details loaded from file.");
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.err.println("Error while loading news details from file.");
        }
        return loadedList;
    }

    public void saveNewsListToFile(ArrayList<News> newsList, String filePath) 
    {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) 
        {
            objectOut.writeObject(newsList);
            System.out.println("News details saved to file: " + filePath);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.err.println("Error while saving news details to file.");
        }
    }
}

