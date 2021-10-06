package comp.comp152;

public class Order {  //Beginning of class Order
    private ShippingAddress destination;  //Declaring Instance variables of classes Shipping Address and Customer
    private Customer orderBy;

    public Order(ShippingAddress destination, Customer orderBy) {  //Declaring constructor of class Order
        super();
        this.destination = destination;  //Initializing the instance variables
        this.orderBy = orderBy;
    }

    public String getDestination() { //Returning the string representation of Shipping Address
        return destination.toString();
    }

    public String getOrderBy() {  //Function to return the string representation of customer who made the order
        return orderBy.toString();
    }
}

//End of class Order


