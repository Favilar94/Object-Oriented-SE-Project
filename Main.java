import Movies.*;

public class Main {
    public static void main(String[] args)
    {
    Movie terminatorMovie = new RegularMovie("Terminator");
    Movie myLittleMovie = new ChildrenMovie("My Little Pony");
    Movie minecraftMovie = new NewReleaseMovie("minecraftMovie"); 

    Rental rental1 = new Rental(terminatorMovie, 14);
    Rental rental2 = new Rental(myLittleMovie, 7);
    Rental rental3 = new Rental(minecraftMovie, 3);

    Customer customer1 = new Customer("Smith");

    customer1.addRental(rental1);
    customer1.addRental(rental2);
    customer1.addRental(rental3);

    Statement.printStatement(customer1);    
    
    }
}
