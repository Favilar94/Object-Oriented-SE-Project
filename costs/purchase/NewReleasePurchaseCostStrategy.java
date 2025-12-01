package costs.purchase;

public class NewReleasePurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost() {
        double thisAmount = 30;
        return thisAmount;

    }
}
