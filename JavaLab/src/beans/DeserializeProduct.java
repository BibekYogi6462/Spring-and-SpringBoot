package beans;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DeserializeProduct
{
    public static void main(String args[])
    {
        System.out.println("Program 2: Deserializing ProductBean");
        System.out.println("========================================");
        
        // Deserialize products from file
        try
        {
            // Read first product
            FileInputStream fileIn1 = new FileInputStream("product1.ser");
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            ProductBean product1 = (ProductBean) in1.readObject();
            in1.close();
            fileIn1.close();
            
            // Read second product
            FileInputStream fileIn2 = new FileInputStream("product2.ser");
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            ProductBean product2 = (ProductBean) in2.readObject();
            in2.close();
            fileIn2.close();
            
            // Read third product
            FileInputStream fileIn3 = new FileInputStream("product3.ser");
            ObjectInputStream in3 = new ObjectInputStream(fileIn3);
            ProductBean product3 = (ProductBean) in3.readObject();
            in3.close();
            fileIn3.close();
            
            System.out.println("Products deserialized successfully!");
            
            // Display deserialized products
            System.out.println("\nDeserialized Products:");
            product1.display();
            product2.display();
            product3.display();
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
            System.out.println("Please run SerializeProduct first to create the files.");
        }
        catch (IOException e)
        {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}