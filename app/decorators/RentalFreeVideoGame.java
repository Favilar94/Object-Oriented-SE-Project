package app.decorators;

import app.Rental;
import items.VideoGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalFreeVideoGame  extends RentalDecorator{
    private final Rental decoratedRental;

    public RentalFreeVideoGame(Rental rental) {
        super(rental);
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        if(this.decoratedRental.getItem() instanceof VideoGame){
            return 0.0;
        }else{
            //Coupon does not apply
            return this.decoratedRental.getRentalCost();
        }
    }

    @Override
    public List<String> getAppliedCoupons() {
        List<String> coupons = new ArrayList<>();
        coupons.addAll(decoratedRental.getAppliedCoupons());
        if (this.decoratedRental.getItem() instanceof VideoGame) {
            coupons.add("FreeVideoGame");
        }
        return Collections.unmodifiableList(coupons);
    }
}
