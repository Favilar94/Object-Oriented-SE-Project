package app;

import items.ItemOperation;


public class Purchase {
    private Item item;

    public Purchase(Item item) {
        if(! (item instanceof app.Purchasable)) {
            throw new IllegalArgumentException("Item is not rentable: " + item);
        }
        this.item = item;
        this.item.assignStrategies(ItemOperation.PURCHASE);
    }

    public Item getItem() {
        return this.item;
    }

    public String getItemTitle() {
        return this.item.getTitle();
    }

    public double getPurchaseCost() {
        return this.item.purchaseCostStrategy.getCost(this.item.getItemType());

    }

    public int getPurchaseRewards(int customerAge) {
        return this.item.purchaseRewardsStrategy.getRewardPoints(customerAge);
    }

}
