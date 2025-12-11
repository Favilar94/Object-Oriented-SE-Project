package costs.purchase;

import items.BookType;
import items.Version;

public class BookPurchaseCostStrategy implements PurchaseCostStrategy{
    
    @Override
    public double getCost(String itemType) {
        if(itemType.equals(BookType.PAPERBACK.toString())){
            return 20.0;

        }
        else if(itemType.equals(BookType.HARDCOVER.toString())){
            return 35.0;

        }
        else{
            throw new IllegalArgumentException("Unknown Book version: " + itemType);
        }
    }
}
