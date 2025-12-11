package items;

import app.Item;
import costs.purchase.PlaystationPurchaseCostStrategy;

import rewards.purchase.PlaystationPurchaseRewardStrategy;
public class Playstation extends Item implements app.Purchasable{

    private Version version;


    public Playstation(String title, Version version) {
        super(title, null);
        this.version = version;
    }

    public Version getVersion() {
        return this.version;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {
        if(operation == ItemOperation.PURCHASE) {
            if (this.getVersion() == Version.PRO) {
                this.purchaseCostStrategy = new PlaystationPurchaseCostStrategy();
                this.purchaseRewardsStrategy = new PlaystationPurchaseRewardStrategy();
            } else if (this.getVersion() == Version.STANDARD) {
                this.purchaseCostStrategy = new PlaystationPurchaseCostStrategy();
                this.purchaseRewardsStrategy = new PlaystationPurchaseRewardStrategy();
            } else {
                throw new IllegalArgumentException("Unsupported version type: " + getClass());
            }
        }else{
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
    
    @Override
    public String getItemType() {
        return version.toString();
    }
}
