package app;

import items.ItemOperation;
import java.util.Collections;
import java.util.List;


public class Purchase {
    private Item item;

    public Purchase(Item item) {
        if(!item.getIsPurchasable()){
            throw new IllegalArgumentException("Item is not purchasable: " + item);
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
        return this.item.getPurchaseCost();

    }

    public double getOriginalPurchaseCost() {
        return this.item.getPurchaseCost();
    }

    public List<String> getAppliedCoupons() {
        return Collections.emptyList();
    }

    public int getPurchaseRewards(int customerAge) {
        return this.item.getPurchaseRewards(customerAge);
    }

}
