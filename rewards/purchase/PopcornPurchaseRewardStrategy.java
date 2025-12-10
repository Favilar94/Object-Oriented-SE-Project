package rewards.purchase;

public class PopcornPurchaseRewardStrategy implements PurchaseRewardStrategy{
    @Override
    public int getRewardPoints(int customerAge){
        return 3;
    }
}
