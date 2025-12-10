package costs.purchase;

public class NewReleasePurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost(String itemType) {
        double thisAmount = 30;
        return thisAmount;

    }
}
