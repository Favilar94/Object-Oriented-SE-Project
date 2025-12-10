package app;
import java.time.LocalDate;

import app.decorators.Customer5Off;
import app.decorators.Rental1Off;
import app.decorators.Rental50PercentOff;
import app.decorators.RentalFree;
import items.Movie;
import items.MovieType;
import items.Popcorn;


public class Main {
    public static void main(String[] args) {
        
        //Products//
        int currentRewardsPoints = 15; //Assuming that is coming from the customer profile

        Item terminatorMovie = new Movie("The Terminator", MovieType.REGULAR ,LocalDate.parse("1984-10-26"));
        Item minecraftMovie = new Movie("A Minecraft Movie", MovieType.CHILDREN, LocalDate.parse("2025-04-04"));
        Item tronAresMovie = new Movie("Tron Ares", MovieType.REGULAR, LocalDate.parse("2025-11-10"));
        Item donnieDarkoMovie = new Movie("Donnie Darko", MovieType.REGULAR, LocalDate.parse("2001-11-26"));

        Item popcorn = new Popcorn("Large Popcorn", items.Sizes.LARGE);
        Item Playstation5Pro = new items.Playstation("Playstation 5", items.Version.PRO);
        
        Item UnchartedGame = new items.VideoGame("Uncharted", items.Version.STANDARD, LocalDate.parse("2010-11-26"));



        /// Rentals//
        Rental rental1 = new Rental(terminatorMovie, 14);
        rental1 = new Rental50PercentOff(rental1);
        Rental rental2 = new Rental(minecraftMovie, 7);
        rental2 = new Rental1Off(rental2);
        
        Rental rental3 = new Rental(tronAresMovie, 3);
        if(currentRewardsPoints > 10) {
            rental3 = new RentalFree(rental3);
            currentRewardsPoints -= 10; 
        }
        Rental rental4 = new Rental(UnchartedGame, 5);

        //Purchases//
        Purchase purchase1 = new Purchase(donnieDarkoMovie);
        Purchase purchasePopcorn = new Purchase(popcorn);
        Purchase purchasePS5 = new Purchase(Playstation5Pro);

        //Transactions//
        Transaction transaction = new Transaction();
        transaction.addRental(rental1);
        transaction.addRental(rental2);
        transaction.addRental(rental3);
        transaction.addRental(rental4);

        transaction.addPurchase(purchase1);
        transaction.addPurchase(purchasePopcorn);
        transaction.addPurchase(purchasePS5);


        //Payment, transaction coupons and Statement//
        Customer customer1 = new Customer(transaction, "Smith", 21, currentRewardsPoints);
        customer1 = new Customer5Off(customer1);

        customer1.finishTransaction();
        Statement.printStatement(customer1);

    }
}
