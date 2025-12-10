package costs.purchase;

import items.Version;

public class PlaystationPurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost(String itemType) {

        if(itemType.equals(Version.PRO.toString())){
            return 800.0;
        }
        else if(itemType.equals(Version.STANDARD.toString())){
            return 600.0;

        }else{
            throw new IllegalArgumentException("Unknown Playstation version: " + itemType);
        }

    }
    
}
