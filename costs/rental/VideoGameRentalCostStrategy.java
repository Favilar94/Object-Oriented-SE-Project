package costs.rental;

public class VideoGameRentalCostStrategy implements RentalCostStrategy{

    @Override
    public double getCost(int daysRented) {
        return daysRented * 5;
    }
    
}
