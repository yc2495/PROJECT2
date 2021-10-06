package comp.comp152;

import java.io.IOException;          //importing all the required packages
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Store {                        // beginning of Store class

    private ArrayList<Order> Orders;         // creating two array lists of classes Orders and Customers
    private ArrayList<Customer> Customers;
    private Scanner sc;

    public Store() {                         //constructor of class Store

        sc = new Scanner(System.in);
        Customers = new ArrayList<Customer>(); //initialising array lists of
        Orders = new ArrayList<Order>();       // class Customers and Orders

        List<String> lines = Collections.emptyList();   /*list of type string to store the customer names from Customer.txt*/

        try                 /*try catch block to handle exceptions while reading the file*/
        {
            lines = Files.readAllLines(Paths.get("/Users/Admin/IdeaProjects/PROJECT2/src/comp/comp152/Customers.txt")); /*reading the file*/
        }catch (IOException e)
        {
            e.printStackTrace();   //executed incase exception caught
        }

        String[] names = lines.get(0).split(","); // to obtain customer names from the text file*/

        Arrays.asList(names).forEach(custName -> {
            Customers.add(new Customer(custName)); /*adding customer names from the text file to customer names list*/
        });
    }

    public void runStore() { //beginning of method runStore

        while(true) {       //displaying the menu for the user
            System.out.println("MENU");
            System.out.println("1. Add Customer");
            System.out.println("2. Select Customer");
            System.out.println("3. Exit the Program");
            System.out.print("Enter you choice : ");
            int ch = sc.nextInt();      //inputting user’s choice

            switch (ch) {               /*switch case statement to implement the menu driven program*/
                case 1:
                    addCustomer();     /*invoking addCustomer method to add a new customer*/
                    break;
                case 2:
                    manageCustomer(selectCustomer()); /*invoking manageCustomer method for a selected customer using selectCustomer method*/
                    break;

                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public void makeOrder(ShippingAddress address, Customer cust) {
        Orders.add(new Order(address,cust));  /*adding address and customer name to the Orders list*/
    }

    public void addCustomer() {
        System.out.print("Enter Customer Name : ");
        String name = sc.next();
        Customer cust = new Customer(name); /*adding new customer names to the customer lists*/
        Customers.add(cust);
        System.out.println("Customer has been successfully added");
    }

    public Customer selectCustomer() {
        int i = 0;
        for(Customer cust : Customers) {
            System.out.println(i++ + " "+cust.getName()); /* displaying the customers list*/
        }
        System.out.print("Select Customer : ");
        int ch = sc.nextInt();        /*asking user to enter the customer to manage*/
        return Customers.get(ch);
    }

    public void manageCustomer(Customer selectCustomer) {
        System.out.println("CUSTOMER MENU");   /*menu-driven program to manage customer details*/
        System.out.println("1. Add Address");
        System.out.println("2. Make Order");
        System.out.print("Enter you choice : ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                String addressLine1 = "", addressLine2= "", city= "", state= "", postalCode="";
                System.out.println("Enter addressLine1");
                if(sc.hasNext()) {
                    sc.next();
                }
                addressLine1 = sc.next();
                System.out.println("Enter addressLine2"); /*inputting address of the user*/
                addressLine2 = sc.next();
                System.out.println("Enter city");
                city = sc.next();
                System.out.println("Enter state");
                state = sc.next();
                System.out.println("Enter postalCode");
                postalCode = sc.next();
                ShippingAddress newAddress = new ShippingAddress(addressLine1, addressLine2, city, state, postalCode);
                selectCustomer.addAddress(newAddress); /*adding the string to the newAddress instance of ShippingAddress class*/
                System.out.println("Address added successfully!");
                break;
            case 2:
                ArrayList<ShippingAddress> addrs = selectCustomer.getAddresses();  /*obtaining the existing address of the customer*/
                int i = 0;
                for(ShippingAddress addr : addrs) {
                    System.out.println(i++ +" "+addr); /*displaying the address list*/
                }
                System.out.print("Enter you choice : ");  /* Taking user choice as input */
                int c = sc.nextInt();
                makeOrder(addrs.get(c), selectCustomer);  /* Invoking function makeOrder and passing the customer details as parameters */
                break;
            default:
                System.exit(0);
        }

    }

    public static void main(String[] args) {
        Store store = new Store();    /* Creating a new instance variable of store class */
        store.runStore();     /* Invoking runStore method using the instance variable */
    }
}

//end of class Store

