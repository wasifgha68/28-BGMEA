/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPkg;
import java.io.*;
import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;

public class EmployeeFileHandler 
{
    public ArrayList<EymployeeDetails> loadEmployeeListFromFile(String filePath) 
    {
        ArrayList<EymployeeDetails> loadedList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            loadedList = (ArrayList<EymployeeDetails>) objectIn.readObject();
            System.out.println("Employee details loaded from file.");
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.err.println("Error while loading employee details from file.");
        }
        return loadedList;
    }

    public void saveEmployeeListToFile(ArrayList<EymployeeDetails> employeeList, String filePath) 
    {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) 
        {
            objectOut.writeObject(employeeList);
            System.out.println("Employee details saved to file: " + filePath);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.err.println("Error while saving employee details to file.");
        }
    }
}

    

