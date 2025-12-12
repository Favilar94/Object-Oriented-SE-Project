package app.decorators;

import app.Purchase;
import items.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseFreeBook extends PurchaseDecorator{
    private final Purchase decoratedPurchase;

    public PurchaseFreeBook(Purchase purchase) {
        super(purchase);
        this.decoratedPurchase = purchase;
    }

    @Override
    public double getPurchaseCost() {
        if(this.decoratedPurchase.getItem() instanceof Book){
            return 0.0;
        }else{
            return this.decoratedPurchase.getPurchaseCost();
        }
    }

    @Override
    public List<String> getAppliedCoupons() {
        List<String> coupons = new ArrayList<>();
        coupons.addAll(decoratedPurchase.getAppliedCoupons());
        if (this.decoratedPurchase.getItem() instanceof Book) {
            coupons.add("FreeBook");
        }
        return Collections.unmodifiableList(coupons);
    }
}