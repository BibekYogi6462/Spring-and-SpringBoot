package beansNegha;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SerializeProduct
{
    public static void main(String args[])
    {
        System.out.println("Program 1: Serializing ProductBean");
        System.out.println("========================================");
        
        // Create product objects
        ProductBean product1 = new ProductBean(101, "Laptop", 75000.50);
        ProductBean product2 = new ProductBean(102, "Mouse", 1200.00);
        ProductBean product3 = new ProductBean(103, "Keyboard", 2500.75);
        
        // Display products before serialization
        System.out.println("Products created:");
        product1.display();
        product2.display();
        product3.display();
        
        // Serialize products to file
        try
        {
            // Save first product
            FileOutputStream fileOut1 = new FileOutputStream("product1.ser");
            ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
            out1.writeObject(product1);
            out1.close();
            fileOut1.close();
            System.out.println("Product 1 serialized to product1.ser");
            
            // Save second product
            FileOutputStream fileOut2 = new FileOutputStream("product2.ser");
            ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
            out2.writeObject(product2);
            out2.close();
            fileOut2.close();
            System.out.println("Product 2 serialized to product2.ser");
            
            // Save third product
            FileOutputStream fileOut3 = new FileOutputStream("product3.ser");
            ObjectOutputStream out3 = new ObjectOutputStream(fileOut3);
            out3.writeObject(product3);
            out3.close();
            fileOut3.close();
            System.out.println("Product 3 serialized to product3.ser");
            
            System.out.println("\nAll products serialized successfully!");
            
        }
        catch (IOException e)
        {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }
}