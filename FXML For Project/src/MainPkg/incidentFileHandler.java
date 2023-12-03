package MainPkg;

import java.io.*;
import java.util.ArrayList;

public class incidentFileHandler {
    public ArrayList<Incident> loadIncidentListFromFile(String filePath) {
        ArrayList<Incident> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            loadedList = (ArrayList<Incident>) objectIn.readObject();
            System.out.println("Incident details loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while loading incident details from file.");
        }
        return loadedList;
    }

    public void saveIncidentListToFile(ArrayList<Incident> incidentList, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(incidentList);
            System.out.println("Incident details saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while saving incident details to file.");
        }
    }
}

