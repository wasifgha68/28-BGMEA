package MainPkg;
import java.io.*;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class ProgramFileHandler {
    public ArrayList<Program> loadProgramListFromFile(String filePath) {
        ArrayList<Program> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            loadedList = (ArrayList<Program>) objectIn.readObject();
            System.out.println("Program details loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while loading program details from file.");
        }
        return loadedList;
    }

    public void saveProgramListToFile(ArrayList<Program> programList, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(programList);
            System.out.println("Program details saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while saving program details to file.");
        }
    }
}
