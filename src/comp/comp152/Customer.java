package comp.comp152;

import java.util.ArrayList;    //Importing required packages

public class Customer {      //beginning of class customer
    private static int count = 0;   /* declaring variables of class*/
    private ArrayList<ShippingAddress> Addresses;
    private String Name;
    private int customerID;

    public Customer(String name) {  //Declaring constructor of customer class
        Name = name;   //initializing instance variables
        Addresses = new ArrayList<ShippingAddress>();
        customerID = count++;  //Assigning unique ID to every customer
    }

    public String getName() {  //Function to return name of customer
        return Name;
    }

    public ArrayList<ShippingAddress> getAddresses() {  //Function to return the address of the customer
        return Addresses;

    }

    public void addAddress(ShippingAddress newAddress) {  //Function to add customer address to the list
        Addresses.add(newAddress);
    }

    @Override
    public String toString() {  //Function to return string representation
        return "Customers [Addresses=" + Addresses + ", Name=" + Name + ", customerID=" + customerID + "]";
    }
}

//End of class Customer

