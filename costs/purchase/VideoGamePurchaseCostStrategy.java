package costs.purchase;

import items.Version;

public class VideoGamePurchaseCostStrategy implements PurchaseCostStrategy{
    
        @Override
    public double getCost(String itemType) {
        if(itemType.equals(Version.STANDARD.toString())){
            return 60.0;

        }else{
            throw new IllegalArgumentException("Unknown VideoGame version: " + itemType);
        }

    }
}
