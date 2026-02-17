package beans;

import java.io.Serializable;

public class ProductBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private int productId;
    private String productName;
    private double price;
    
    // Default constructor
    public ProductBean()
    {
        this.productId = 0;
        this.productName = "";
        this.price = 0.0;
    }
    
    // Parameterized constructor (THIS IS MISSING IN YOUR CODE)
    public ProductBean(int productId, String productName, double price)
    {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    
    // Getters and Setters
    public int getProductId()
    {
        return productId;
    }
    
    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    // display() method (THIS IS MISSING IN YOUR CODE)
    public void display()
    {
        System.out.println("\nProduct Details:");
        System.out.println("----------------------------------------");
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("----------------------------------------");
    }
}