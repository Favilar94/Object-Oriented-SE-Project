package app;
import java.time.LocalDate;

import app.decorators.Customer5Off;
import app.decorators.Rental1Off;
import app.decorators.Rental50PercentOff;
import app.decorators.RentalFree;
import items.BookType;
import items.Movie;
import items.MovieType;
import items.Popcorn;


public class Main {
    public static void main(String[] args) {
        
        //Products//
        int currentRewardsPoints = 15; //Assuming that is coming from the customer profile

        Item terminatorMovie = new Movie("The Terminator", LocalDate.parse("1984-10-26"), MovieType.REGULAR );
        Item minecraftMovie = new Movie("A Minecraft Movie", LocalDate.parse("2025-04-04"), MovieType.CHILDREN);
        Item tronAresMovie = new Movie("Tron Ares", LocalDate.parse("2025-11-10"), MovieType.REGULAR);
        Item donnieDarkoMovie = new Movie("Donnie Darko", LocalDate.parse("2001-11-26"), MovieType.REGULAR);

        Item popcorn = new Popcorn("Large Popcorn", items.Sizes.LARGE);

        Item Playstation5Pro = new items.Playstation("Playstation 5", items.Version.PRO);
        
        Item unchartedGame = new items.VideoGame("Uncharted", LocalDate.parse("2010-11-26"), items.Version.STANDARD);
        Item minecraftGame = new items.VideoGame("Minecraft", LocalDate.parse("2011-11-18"), items.Version.STANDARD);

        Item lordOfTheRignBook = new items.Book("The Lord of the Rings", LocalDate.parse("1954-07-29"), BookType.PAPERBACK);
        Item harryPotterBook = new items.Book("Harry Potter and the Sorcerer's Stone", LocalDate.parse("1998-09-1"), BookType.HARDCOVER);

        Item thrillerMusicCD = new items.MusicCD("Top Thriller Hits", LocalDate.parse("2020-10-10"), items.Version.STANDARD);
        Item popMusicCD = new items.MusicCD("Pop Classics", LocalDate.parse("2019-05-05"), items.Version.COLLECTORS_EDITION);


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
        Rental rental4 = new Rental(unchartedGame, 5);

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
