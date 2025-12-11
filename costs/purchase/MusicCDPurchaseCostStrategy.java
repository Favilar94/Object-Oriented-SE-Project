package costs.purchase;

import items.Version;

public class MusicCDPurchaseCostStrategy implements PurchaseCostStrategy{
     @Override
    public double getCost(String itemType) {
        if(itemType.equals(Version.STANDARD.toString())){
            return 30.0;
        }
        else if(itemType.equals(Version.COLLECTORS_EDITION.toString())){
            return 50.0;
        }
        else{
            throw new IllegalArgumentException("Unknown Music CD version: " + itemType);
        }
    }
}
