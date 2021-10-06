package comp.comp152;

public class ShippingAddress { //Beginning of class Shipping Address
    private String AddressLine1; //Declaring instance variables of the class
    private String AddressLine;
    private String City;
    private String State;
    private String PostalCode;

    public ShippingAddress(String addressLine1, String addressLine, String city, String state, String postalCode) { //Declaring constructor of class Shipping Address with instance variables passed as the parameters
        AddressLine1 = addressLine1;  //Initializing instance variables
        AddressLine = addressLine;
        City = city;
        State = state;
        PostalCode = postalCode;
    }

    @Override
    public String toString() { //Returning string representation of the address
        return "ShippingAddress [AddressLine1=" + AddressLine1 + ", AddressLine=" + AddressLine + ", City=" + City
                + ", State=" + State + ", PostalCode=" + PostalCode + "]";
    }

}

//End of class ShippingAddress

