package app;
import java.time.LocalDate;

import movies.ChildrenMovie;
import movies.Movie;
import movies.RegularMovie;


public class Main {
    public static void main(String[] args) {
        
        Movie terminatorMovie = new RegularMovie("The Terminator", LocalDate.parse("1984-10-26"));
        Movie minecraftMovie = new ChildrenMovie("A Minecraft Movie", LocalDate.parse("2025-04-04"));
        Movie TronAres = new RegularMovie("Tron Ares", LocalDate.parse("2025-10-10"));

        Rental rental1 = new Rental(terminatorMovie, 14);
        Rental rental2 = new Rental(minecraftMovie, 7);
        Rental rental3 = new Rental(TronAres, 3);

        Customer customer1 = new Customer("Smith", 21);

        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);

        Statement.printStatement(customer1);

    }
}
