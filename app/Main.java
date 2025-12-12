package app;
import java.time.LocalDate;

import app.decorators.Customer5Off;
import app.decorators.CustomerFreeMovie;
import app.decorators.CustomerFreeVideoGame;
import app.decorators.PurchaseFreeBook;
import app.decorators.Rental1OffAnyItem;
import app.decorators.Rental50PercentOffAnyItem;
import app.decorators.RentalFreeMovie;
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

        Item playstation5Pro = new items.Playstation("Playstation 5", items.Version.PRO);
        
        Item unchartedGame = new items.VideoGame("Uncharted", LocalDate.parse("2010-11-26"), items.Version.STANDARD);
        Item minecraftGame = new items.VideoGame("Minecraft", LocalDate.parse("2011-11-18"), items.Version.STANDARD);

        Item lordOfTheRignBook = new items.Book("The Lord of the Rings", LocalDate.parse("1954-07-29"), BookType.PAPERBACK);
        Item harryPotterBook = new items.Book("Harry Potter and the Sorcerer's Stone", LocalDate.parse("1998-09-01"), BookType.HARDCOVER);

        Item thrillerMusicCD = new items.MusicCD("Top Thriller Hits", LocalDate.parse("2020-10-10"), items.Version.STANDARD);
        Item popMusicCD = new items.MusicCD("Pop Classics", LocalDate.parse("2019-05-05"), items.Version.COLLECTORS_EDITION);


        /// Rentals//
        Rental rentalMovie1 = new Rental(terminatorMovie, 14);
        rentalMovie1 = new Rental50PercentOffAnyItem(rentalMovie1);
        Rental rentalMovie2 = new Rental(minecraftMovie, 7);
        rentalMovie2 = new Rental1OffAnyItem(rentalMovie2);
        
        Rental rentalMovie3 = new Rental(tronAresMovie, 3);
        if(currentRewardsPoints > 10) {
            rentalMovie3 = new RentalFreeMovie(rentalMovie3);
            currentRewardsPoints -= 10; 
        }
        Rental rentalMovie4 = new Rental(unchartedGame, 5);

        //Purchases//
        Purchase purchaseMovie1 = new Purchase(donnieDarkoMovie);
        Purchase purchasePopcorn = new Purchase(popcorn);
        Purchase purchasePS5 = new Purchase(playstation5Pro);
        Purchase purchaseVideoGame = new Purchase(minecraftGame);
        Purchase purchaseBook = new Purchase(harryPotterBook);
        Purchase purchaseBook2 = new Purchase(lordOfTheRignBook);
        purchaseBook2 = new PurchaseFreeBook(purchaseBook2);
        Purchase purchaseMusicCD = new Purchase(thrillerMusicCD);
        Purchase purchaseMusicCD2 = new Purchase(popMusicCD);

        //Transactions//
        Transaction transaction = new Transaction();
        transaction.addRental(rentalMovie1);
        transaction.addRental(rentalMovie2);
        transaction.addRental(rentalMovie3);
        transaction.addRental(rentalMovie4);

        transaction.addPurchase(purchaseMovie1);
        transaction.addPurchase(purchasePopcorn);
        transaction.addPurchase(purchasePS5);
        transaction.addPurchase(purchaseVideoGame);
        transaction.addPurchase(purchaseBook);
        transaction.addPurchase(purchaseBook2);
        transaction.addPurchase(purchaseMusicCD);
        transaction.addPurchase(purchaseMusicCD2);

        
        //Payment, transaction coupons and Statement//
        Customer customer1 = new Customer(transaction, "Smith", 21, currentRewardsPoints);
        customer1 = new Customer5Off(customer1);
        customer1 = new CustomerFreeMovie(customer1);
        customer1 = new CustomerFreeVideoGame(customer1);
        
        customer1.finishTransaction();
        Statement.printStatement(customer1);

    }
}
