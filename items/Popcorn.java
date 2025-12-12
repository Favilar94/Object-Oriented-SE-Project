package items;

import app.Item;


public class Popcorn extends Item{
    private Sizes size;

    public Popcorn(String title, Sizes size) {
        super(title, null, false, true);
        this.size = size;
    }

    public Sizes getMovieType() {
        return this.size;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {
        if (operation == ItemOperation.PURCHASE) {
            this.purchaseCostStrategy = new costs.purchase.PopcornPurchaseCostStrategy();
            this.purchaseRewardsStrategy = new rewards.purchase.PopcornPurchaseRewardStrategy();
        } 
        else{
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
    
    @Override
    public String getItemType() {
        return size.toString();
    }
}
