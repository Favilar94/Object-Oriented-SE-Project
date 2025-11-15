package app;
import java.time.LocalDate;

import app.decorators.Customer5Off;
import app.decorators.Rental1Off;
import app.decorators.Rental50PercentOff;
import app.decorators.RentalFree;
import movies.ChildrenMovie;
import movies.Movie;
import movies.RegularMovie;


public class Main {
    public static void main(String[] args) {
        
        int currentRewardsPoints = 15; //Assuming that is coming from the customer profile

        Movie terminatorMovie = new RegularMovie("The Terminator", LocalDate.parse("1984-10-26"));
        Movie minecraftMovie = new ChildrenMovie("A Minecraft Movie", LocalDate.parse("2025-04-04"));
        Movie TronAres = new RegularMovie("Tron Ares", LocalDate.parse("2025-11-10"));

        Rental rental1 = new Rental(terminatorMovie, 14);
        rental1 = new Rental50PercentOff(rental1);
        Rental rental2 = new Rental(minecraftMovie, 7);
        rental2 = new Rental1Off(rental2);
        
        Rental rental3 = new Rental(TronAres, 3);
        if(currentRewardsPoints > 10) {
            rental3 = new RentalFree(rental3);
            currentRewardsPoints -= 10; 
        }

        Transaction transaction = new Transaction();
        transaction.addRental(rental1);
        transaction.addRental(rental2);
        transaction.addRental(rental3);


        Customer customer1 = new Customer(transaction, "Smith", 21, currentRewardsPoints);
        customer1 = new Customer5Off(customer1);


        Statement.printStatement(customer1);

    }
}
