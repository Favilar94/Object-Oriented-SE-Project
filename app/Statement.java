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
        printItem(rental.getItem(), rental.getItemTitle(), rental.getRentalCost(), rental.getDaysRented());
    }

    private static void printPurchases(Purchase purchase) {
        printItem(purchase.getItem(), purchase.getItemTitle(), purchase.getPurchaseCost(), null);
    }

    private static void printItem(Item item, String name, Double price, Integer daysRented) {
        System.out.println("        <Item>");
        System.out.println("            <Type>" + item.getClass().getSimpleName() + "</Type>");
        System.out.println("            <Version>" + item.getItemType() + "</Version>");
        System.out.println("            <Name>" + name + "</Name>");
        if (daysRented != null) {
            System.out.println("            <DaysRented>" + daysRented + "</DaysRented>");
        }
        System.out.println("            <Price>" + price + "</Price>");
        System.out.println("        </Item>");
    }

}
