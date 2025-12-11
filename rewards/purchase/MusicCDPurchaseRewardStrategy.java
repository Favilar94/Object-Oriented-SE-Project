package rewards.purchase;

public class MusicCDPurchaseRewardStrategy implements PurchaseRewardStrategy{
    
    @Override
    public int getRewardPoints(int customerAge) {
        int rewardPoints = 1;
        return rewardPoints;
    }
    
}
