import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Rental> rentals = new ArrayList<>();
    
    
    public Customer (String name) {
        this.customerName = name;
    }
    
    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    
    public String getCustomerName () {
        return customerName ;
    }
    
    public ArrayList<Rental> getRentals(){
        return this.rentals;
    }

    public double calculateOwedTotal(){
        double totalAmount = 0;

        for (Rental rental : rentals) {
            totalAmount += rental.getRentalCost();
        }
        return totalAmount;

    }

    public int calculateRewardsTotal(){
        int totalRewards = 0;
        for (Rental rental : rentals) {
            totalRewards += rental.getRentalRewards();
        }
        return totalRewards;

    }

}