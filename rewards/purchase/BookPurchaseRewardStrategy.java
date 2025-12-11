package rewards.purchase;

public class BookPurchaseRewardStrategy implements PurchaseRewardStrategy{
    
    @Override
    public int getRewardPoints(int customerAge) {
        int rewardPoints = 2;
        return rewardPoints;
    }
    
}
