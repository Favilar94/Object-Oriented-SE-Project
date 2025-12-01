package rewards.purchase;

public class NewReleasePurchaseRewardStrategy implements PurchaseRewardStrategy{
    @Override
    public int getRewardPoints(int customerAge){
        
        if(customerAge >=65){
            return 2;
        }
        else{
            return 1;
        }
    }
}
