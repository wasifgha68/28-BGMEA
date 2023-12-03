package MainPkg;

import java.io.*;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class EventFileHandler 
{
    public ArrayList<Event2> loadEventListFromFile(String filePath) 
    {
        ArrayList<Event2> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn))
        {
            loadedList = (ArrayList<Event2>) objectIn.readObject();
            System.out.println("Event details loaded from file.");
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.err.println("Error while loading event details from file.");
        }
        return loadedList;
    }

    public void saveEventListToFile(ArrayList<Event2> eventList, String filePath) 
    {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) 
        {
            objectOut.writeObject(eventList);
            System.out.println("Event details saved to file: " + filePath);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            System.err.println("Error while saving event details to file.");
        }
    }
}
