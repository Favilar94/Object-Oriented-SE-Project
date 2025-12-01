package costs.rental;

public class ChildrenRentalCostStrategy implements RentalCostStrategy{
    
    @Override
    public double getCost(int daysRented) {
        double thisAmount = 1.5;
        
        if(daysRented > 3){
            return thisAmount + ((daysRented - 3) * 1.5);
        }else{
            return thisAmount;
        }    
    }
}
