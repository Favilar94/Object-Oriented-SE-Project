package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Transaction {
    private List<Rental> rentals = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();


    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(this.rentals);
    }


    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public List<Purchase> getPurchases() {
        return Collections.unmodifiableList(this.purchases);
    }



    public double calculateOwedTotal() {
        double totalAmount = 0;

        for (Rental rental : this.rentals) {
            totalAmount += rental.getRentalCost();
        }
        for( Purchase purchase : this.purchases) {
            totalAmount += purchase.getPurchaseCost();
        }

        return totalAmount;
    }

    public int calculateRewardsTotal(int customerAge) {
        int totalRewards = 0;
        for (Rental rental : this.rentals) {
            totalRewards += rental.getRentalRewards(customerAge);
        }
        for (Purchase purchase : this.purchases) {
            totalRewards += purchase.getPurchaseRewards(customerAge);
        }

        return totalRewards;
    }
}
