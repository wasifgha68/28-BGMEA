package MainPkg;
import java.io.*;
import java.util.ArrayList;

public class SupplierFileHandler {
    public ArrayList<SupplierTableView> loadSupplierListFromFile(String filePath) {
        ArrayList<SupplierTableView> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            loadedList = (ArrayList<SupplierTableView>) objectIn.readObject();
            System.out.println("Supplier details loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while loading supplier details from file.");
        }
        return loadedList;
    }

    public void saveSupplierListToFile(ArrayList<SupplierTableView> supplierList, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(supplierList);
            System.out.println("Supplier details saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while saving supplier details to file.");
        }
    }
}