package rewards.purchase;

public class RegularPurchaseRewardStrategy implements PurchaseRewardStrategy{
    @Override
    public int getRewardPoints(int customerAge){
        return 1;
    }

}
