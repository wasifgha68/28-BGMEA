package MainPkg;

import java.io.*;
import java.util.ArrayList;

public class vendorFileHandler {
    public ArrayList<Vendor> loadVendorListFromFile(String filePath) {
        ArrayList<Vendor> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            loadedList = (ArrayList<Vendor>) objectIn.readObject();
            System.out.println("Vendor details loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while loading vendor details from file.");
        }
        return loadedList;
    }

    public void saveVendorListToFile(ArrayList<Vendor> vendorList, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(vendorList);
            System.out.println("Vendor details saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while saving vendor details to file.");
        }
    }
}
