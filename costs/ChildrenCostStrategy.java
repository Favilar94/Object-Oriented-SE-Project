package costs;

public class ChildrenCostStrategy implements CostStrategy{
    
    @Override
    public double getMovieRentalCost(int daysRented) {
        double thisAmount = 1.5;
        
        if(daysRented > 3){
            return thisAmount + ((daysRented - 3) * 1.5);
        }else{
            return thisAmount;
        }    
    }
}
