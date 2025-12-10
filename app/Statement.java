package app;

import java.util.List;

public final class Statement {

    public static void printStatement(Customer customer) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<Rental>");
        System.out.println("    <CustomerName>" + customer.getCustomerName() + "</CustomerName>");

        System.out.println("    <RentedMovies>");
        List<Rental> rentals = customer.getRentals();
        rentals.forEach((n) -> printRental(n));
        System.out.println("    </RentedMovies>");

        System.out.println("    <PurchasedMovies>");
        List<Purchase> purchases = customer.getPurchases();
        purchases.forEach((n) -> printPurchases(n));
        System.out.println("    </PurchasedMovies>");

        System.out.println("    <TotalOwed>" + customer.calculateOwedTotal() + "</TotalOwed>");
        System.out.println("    <RewardsPoints>" + customer.calculateRewardsTotal() + "</RewardsPoints>");
        System.out.println("</Rental>");

    }

    private static void printRental(Rental rental) {
        double price = rental.getRentalCost();
        System.out.println("        <Movie>");
        System.out.println("            <Name>" + rental.getItemTitle() + "</Name>");
        System.out.println("            <DaysRented>" + rental.getDaysRented() + "</DaysRented>");
        System.out.println("            <Price>" + price + "</Price>");
        System.out.println("        </Movie>");
    }

    private static void printPurchases(Purchase purchase) {
        double price = purchase.getPurchaseCost();
        System.out.println("        <Movie>");
        System.out.println("            <Name>" + purchase.getItemTitle() + "</Name>");
        System.out.println("            <Price>" + price + "</Price>");
        System.out.println("        </Movie>");
    }

}
