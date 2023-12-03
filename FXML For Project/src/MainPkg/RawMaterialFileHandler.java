package MainPkg;
import java.io.*;
import java.util.ArrayList;

public class RawMaterialFileHandler {
    public ArrayList<RawMaterial> loadRawMaterialListFromFile(String filePath) {
        ArrayList<RawMaterial> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            loadedList = (ArrayList<RawMaterial>) objectIn.readObject();
            System.out.println("Raw material details loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while loading raw material details from file.");
        }
        return loadedList;
    }

    public void saveRawMaterialListToFile(ArrayList<RawMaterial> RawMaterialList, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(RawMaterialList);
            System.out.println("Raw material details saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while saving raw material details to file.");
        }
    }
}