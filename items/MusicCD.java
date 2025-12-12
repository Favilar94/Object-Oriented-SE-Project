package items;

import java.time.LocalDate;

import app.Item;

public class MusicCD extends Item{
    
    private Version version;

    public MusicCD(String title, LocalDate releaseDate, Version version) {
        super(title, releaseDate, false, true);
        this.version = version;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {
        if (operation == ItemOperation.PURCHASE) {
            this.purchaseCostStrategy = new costs.purchase.MusicCDPurchaseCostStrategy();
            this.purchaseRewardsStrategy = new rewards.purchase.MusicCDPurchaseRewardStrategy();
        } 
        else{
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
    

   @Override
    public String getItemType() {
        return version.toString();
    }
}
