package app;

import java.util.List;

public final class Statement {

    public static void printStatement(Customer customer) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<Rental>");
        System.out.println("    <CustomerName>" + customer.getCustomerName() + "</CustomerName>");

        System.out.println("    <Movies>");
        List<Rental> rentals = customer.getRentals();
        rentals.forEach((n) -> printRental(n));
        System.out.println("    </Movies>");

        System.out.println("    <TotalOwed>" + customer.calculateOwedTotal() + "</TotalOwed>");
        System.out.println("    <RewardsPoints>" + customer.calculateRewardsTotal() + "</RewardsPoints>");
        System.out.println("</Rental>");

    }

    private static void printRental(Rental rental) {
        double price = rental.getRentalCost();
        System.out.println("        <Movie>");
        System.out.println("            <Name>" + rental.getMovieTitle() + "</Name>");
        System.out.println("            <DaysRented>" + rental.getDaysRented() + "</DaysRented>");
        System.out.println("            <Price>" + price + "</Price>");

        System.out.println("        </Movie>");
    }

}
