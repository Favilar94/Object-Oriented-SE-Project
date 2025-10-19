package costs;

public class RegularMovieCostStrategy implements CostStrategy{
    
    @Override
    public double getMovieRentalCost(int daysRented) {
        double thisAmount = 2;
        
        if(daysRented > 2){
            return thisAmount + ((daysRented - 2) * 1.5);
        }else{
            return thisAmount;
        }    
    }
}
