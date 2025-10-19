package costs;

public class NewReleaseCostStrategy implements CostStrategy{
    
    @Override
    public double getMovieRentalCost(int daysRented) {
        return daysRented * 3;
    }
}
