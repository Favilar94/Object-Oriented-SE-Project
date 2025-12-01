package costs.rental;

public class NewReleaseRentalCostStrategy implements RentalCostStrategy{
    
    @Override
    public double getCost(int daysRented) {
        return daysRented * 3;
    }
}
