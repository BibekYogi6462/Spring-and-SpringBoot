package beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TestPerson
{
    public static void main(String args[])
    {
        System.out.println("Testing Bound Property - Person Bean");
        System.out.println("========================================");
        
        // Create a Person object
        Person person = new Person();
        person.setName("Bibek");
        System.out.println("Initial name: " + person.getName());
        
        // Register a PropertyChangeListener
        person.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("\nPROPERTY CHANGE DETECTED!");
                System.out.println("Property: " + evt.getPropertyName());
                System.out.println("Old value: " + evt.getOldValue());
                System.out.println("New value: " + evt.getNewValue());
            }
        });
        
        System.out.println("\nChanging name from 'Bibek' to 'Bibek Yogi'...");
        person.setName("Bibek Yogi");
        
        System.out.println("\nCurrent name: " + person.getName());
        
        System.out.println("\nChanging name from 'Bibek Yogi' to 'Dr. Bibek Yogi'...");
        person.setName("Dr. Bibek Yogi");
        
        System.out.println("\nFinal name: " + person.getName());
    }
}