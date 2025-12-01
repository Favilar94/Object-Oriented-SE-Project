package costs.purchase;


public class RegularMoviePurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost() {
        double thisAmount = 21;
        return thisAmount;
    }
}
