package app.decorators;

import app.Rental;
import items.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalFreeMovie extends RentalDecorator{
    private final Rental decoratedRental;

    public RentalFreeMovie(Rental rental) {
        super(rental);
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        if(this.decoratedRental.getItem() instanceof Movie){
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
        if (this.decoratedRental.getItem() instanceof Movie) {
            coupons.add("FreeMovie");
        }
        return Collections.unmodifiableList(coupons);
    }
}
