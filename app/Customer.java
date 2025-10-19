package app;
import java.util.ArrayList;

public class Customer {
    private String customerName;
    private int age;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String name, int age) {
        this.customerName = name;
        this.age = age;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getCustomerAge() {
        return this.age;
    }

    public ArrayList<Rental> getRentals() {
        return this.rentals;
    }

    public double calculateOwedTotal() {
        double totalAmount = 0;

        for (Rental rental : rentals) {
            totalAmount += rental.getRentalCost();
        }
        return totalAmount;

    }

    public int calculateRewardsTotal() {
        int totalRewards = 0;
        for (Rental rental : rentals) {
            totalRewards += rental.getRentalRewards(getCustomerAge());
        }
        return totalRewards;

    }

}