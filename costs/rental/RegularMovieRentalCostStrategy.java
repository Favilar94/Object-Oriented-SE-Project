package costs.rental;

public class RegularMovieRentalCostStrategy implements RentalCostStrategy{
    
    @Override
    public double getCost(int daysRented) {
        double thisAmount = 2;
        
        if(daysRented > 2){
            return thisAmount + ((daysRented - 2) * 1.5);
        }else{
            return thisAmount;
        }    
    }
}
