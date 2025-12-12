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
        purchases.forEach((n) -> printPurchase(n));
        System.out.println("    </PurchasedItems>");

        System.out.println("    <TotalOwed>" + customer.calculateOwedTotal() + "</TotalOwed>");
        System.out.println("    <RewardsPoints>" + customer.calculateRewardsTotal() + "</RewardsPoints>");
        java.util.List<String> customerCoupons = customer.getAppliedCoupons();
        if (!customerCoupons.isEmpty()) {
            System.out.println("    <AppliedCustomerCoupons>");
            for (String c : customerCoupons) {
                System.out.println("        <Coupon>" + c + "</Coupon>");
            }
            System.out.println("    </AppliedCustomerCoupons>");
        }
        System.out.println("</Rental>");

    }
    private static void printRental(Rental rental) {
        Item item = rental.getItem();
        double price = rental.getRentalCost();
        double original = rental.getOriginalRentalCost();
        java.util.List<String> coupons = rental.getAppliedCoupons();

        System.out.println("        <Item>");
        System.out.println("            <Type>" + item.getClass().getSimpleName() + "</Type>");
        System.out.println("            <Version>" + item.getItemType() + "</Version>");
        System.out.println("            <Name>" + rental.getItemTitle() + "</Name>");
        System.out.println("            <DaysRented>" + rental.getDaysRented() + "</DaysRented>");
        System.out.println("            <OriginalPrice>" + original + "</OriginalPrice>");
        System.out.println("            <Price>" + price + "</Price>");
        if (!coupons.isEmpty()) {
            System.out.println("            <AppliedCoupons>");
            for (String c : coupons) {
                System.out.println("                <Coupon>" + c + "</Coupon>");
            }
            System.out.println("            </AppliedCoupons>");
        }
        System.out.println("        </Item>");
    }

    private static void printPurchase(Purchase purchase) {
        Item item = purchase.getItem();
        double price = purchase.getPurchaseCost();
        double original = purchase.getOriginalPurchaseCost();
        java.util.List<String> coupons = purchase.getAppliedCoupons();

        System.out.println("        <Item>");
        System.out.println("            <Type>" + item.getClass().getSimpleName() + "</Type>");
        System.out.println("            <Version>" + item.getItemType() + "</Version>");
        System.out.println("            <Name>" + purchase.getItemTitle() + "</Name>");
        System.out.println("            <OriginalPrice>" + original + "</OriginalPrice>");
        System.out.println("            <Price>" + price + "</Price>");
        if (!coupons.isEmpty()) {
            System.out.println("            <AppliedCoupons>");
            for (String c : coupons) {
                System.out.println("                <Coupon>" + c + "</Coupon>");
            }
            System.out.println("            </AppliedCoupons>");
        }
        System.out.println("        </Item>");
    }

}
