package costs.purchase;

import items.Version;

public class BookPurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost(String itemType) {
        if(itemType.equals(Version.STANDARD.toString())){
            return 20.0;

        }else{
            throw new IllegalArgumentException("Unknown Book version: " + itemType);
        }
    }
}
