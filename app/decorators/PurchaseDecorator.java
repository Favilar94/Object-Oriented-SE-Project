package app.decorators;

import app.Purchase;

public class PurchaseDecorator extends Purchase {
    public PurchaseDecorator(Purchase purchase)
    {
        super(purchase.getItem());
    }
}
