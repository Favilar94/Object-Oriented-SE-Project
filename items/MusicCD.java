package items;

import java.time.LocalDate;

import app.Item;

public class MusicCD extends Item implements app.Purchasable{
    
    private Version version;

    public MusicCD(String title, LocalDate releaseDate, Version version) {
        super(title, releaseDate);
        this.version = version;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {
        if (operation == ItemOperation.PURCHASE) {
            this.pruchaseCostStrategy = new costs.purchase.MusicCDPurchaseCostStrategy();
            this.pruchaseRewardsStrategy = new rewards.purchase.MusicCDPurchaseRewardStrategy();
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
