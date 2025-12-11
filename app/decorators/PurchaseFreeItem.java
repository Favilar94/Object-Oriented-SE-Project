package app.decorators;

import app.Item;
import app.Purchase;
import items.Movie;
import items.Popcorn;
import items.VideoGame;

public class PurchaseFreeItem extends PurchaseDecorator{
    private final Purchase purchase;

    public PurchaseFreeItem(Purchase purchase){
        super(purchase);
        this.purchase = purchase;
    }


    @Override
    public double getPurchaseCost(){
        Item item = this.purchase.getItem();
        if(item instanceof Movie ||
            item instanceof VideoGame ||
            item instanceof Popcorn){
            return 0;
        }
        return this.purchase.getPurchaseCost();
    }
}
