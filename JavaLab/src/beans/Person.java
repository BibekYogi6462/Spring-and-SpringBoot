package beans;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Person implements Serializable
{
    private String name;
    private PropertyChangeSupport propertyChangeSupport;
    
    // Default constructor
    public Person()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
        this.name = "";
    }
    
    // Constructor with name
    public Person(String name)
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
        this.name = name;
    }
    
    // Getter for name
    public String getName()
    {
        return name;
    }
    
    // Setter for name (bound property - notifies listeners)
    public void setName(String newName)
    {
        String oldName = this.name;
        this.name = newName;
        
        // Notify listeners that property has changed
        propertyChangeSupport.firePropertyChange("name", oldName, newName);
    }
    
    // Method to add PropertyChangeListener
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    // Method to remove PropertyChangeListener
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    // Display method
    public void display()
    {
        System.out.println("Person Name: " + name);
    }
}