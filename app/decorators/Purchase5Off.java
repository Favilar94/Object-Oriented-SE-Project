package app.decorators;

import app.Item;
import app.Purchase;
import items.Movie;
import items.Playstation;
import items.Popcorn;
import items.VideoGame;

public class Purchase5Off extends PurchaseDecorator{
    private final Purchase purchase;

    public Purchase5Off(Purchase purchase){
        super(purchase);
        this.purchase = purchase;
    }

    @Override
    public double getPurchaseCost(){
        Item item = this.purchase.getItem();
        if (item instanceof Movie ||
                item instanceof VideoGame ||
                item instanceof Playstation)
            return this.purchase.getPurchaseCost() - 5;
        return this.purchase.getPurchaseCost();
    }

}
