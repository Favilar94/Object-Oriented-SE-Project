package costs.purchase;

public class ChildrenPurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost() {
        double thisAmount = 20;
        return thisAmount;
    }
}
