package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Transaction {
    private ArrayList<Rental> rentals = new ArrayList<>();


    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(this.rentals);
    }

    public double calculateOwedTotal() {
        double totalAmount = 0;

        for (Rental rental : this.rentals) {
            totalAmount += rental.getRentalCost();
        }
        return totalAmount;
    }

    public int calculateRewardsTotal(int customerAge) {
        int totalRewards = 0;
        for (Rental rental : this.rentals) {
            totalRewards += rental.getRentalRewards(customerAge);
        }
        return totalRewards;
    }
}
