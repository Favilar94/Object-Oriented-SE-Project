package rewards.purchase;


public class VideoGamePurchaseRewardStrategy implements PurchaseRewardStrategy{
    @Override
    public int getRewardPoints(int customerAge) {
        int rewardPoints = 2;
        return rewardPoints;
    }
}
