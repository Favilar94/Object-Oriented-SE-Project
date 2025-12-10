package costs.purchase;

import items.Sizes;

public class PopcornPurchaseCostStrategy implements PurchaseCostStrategy{
    @Override
    public double getCost(String itemType){

        if(itemType.equals(Sizes.SMALL.toString())){
            return 6.0;
        }
        else if(itemType.equals(Sizes.MEDIUM.toString())){
            return 8.0;
        }
        else if(itemType.equals(Sizes.LARGE.toString())){
            return 10.0;
        }
        else{
            throw new IllegalArgumentException("Unknown PopCorn Size: " + itemType);
        }


    }
    
}
