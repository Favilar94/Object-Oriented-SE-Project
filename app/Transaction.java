package app;

import java.util.ArrayList;
import java.util.List;


public class Transaction {
    private List<Rental> rentals;
    private List<Purchase> purchases;

    public Transaction(List<Rental> rentals, List<Purchase> purchases){
        this.rentals = new ArrayList<>(rentals);
        this.purchases = new ArrayList<>(purchases);
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }

    public List<Purchase> getPurchases() {
        return this.purchases;
    }

    public void addRental(Rental rental){
        this.rentals.add(rental);
    }

    public void addPurchase(Purchase purchase){
        this.purchases.add(purchase);
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
