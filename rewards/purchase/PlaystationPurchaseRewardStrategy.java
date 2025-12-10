package rewards.purchase;

public class PlaystationPurchaseRewardStrategy implements PurchaseRewardStrategy{
    
    @Override
    public int getRewardPoints(int customerAge) {
        int rewardPoints = 20;
        return rewardPoints;
    }
    
}
