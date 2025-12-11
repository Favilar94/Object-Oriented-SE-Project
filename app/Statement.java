package app;

import java.util.List;

public final class Statement {

    public static void printStatement(Customer customer) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<Rental>");
        System.out.println("    <CustomerName>" + customer.getCustomerName() + "</CustomerName>");

        System.out.println("    <RentedItems>");
        List<Rental> rentals = customer.getRentals();
        rentals.forEach((n) -> printRental(n));
        System.out.println("    </RentedItems>");

        System.out.println("    <PurchasedItems>");
        List<Purchase> purchases = customer.getPurchases();
        purchases.forEach((n) -> printPurchases(n));
        System.out.println("    </PurchasedItems>");

        System.out.println("    <TotalOwed>" + customer.calculateOwedTotal() + "</TotalOwed>");
        System.out.println("    <RewardsPoints>" + customer.calculateRewardsTotal() + "</RewardsPoints>");
        System.out.println("</Rental>");

    }

    private static void printRental(Rental rental) {
        double price = rental.getRentalCost();
        System.out.println("        <Item>");
        System.out.println("            <Type>" + rental.getItem().getClass().toString()+ "</Type>");
        System.out.println("            <Version>" + rental.getItem().getItemType()+ "</Version>");

        System.out.println("            <Name>" + rental.getItemTitle() + "</Name>");
        System.out.println("            <DaysRented>" + rental.getDaysRented() + "</DaysRented>");
        System.out.println("            <Price>" + price + "</Price>");
        System.out.println("        </Item>");
    }

    private static void printPurchases(Purchase purchase) {
        double price = purchase.getPurchaseCost();
        System.out.println("        <Item>");
        System.out.println("            <Type>" + purchase.getItem().getClass().toString()+ "</Type>");
        System.out.println("            <Version>" + purchase.getItem().getItemType()+ "</Version>");
        System.out.println("            <Name>" + purchase.getItemTitle() + "</Name>");
        System.out.println("            <Price>" + price + "</Price>");
        System.out.println("        </Item>");
    }
}
