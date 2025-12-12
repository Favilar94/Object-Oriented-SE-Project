package app.decorators;

import app.Rental;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rental50PercentOffAnyItem extends RentalDecorator{
    private final Rental decoratedRental;

    public Rental50PercentOffAnyItem(Rental rental) {
        super(rental);
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        double originalPrice = this.decoratedRental.getRentalCost();
        return originalPrice * 0.5;
    }

    @Override
    public List<String> getAppliedCoupons() {
        List<String> coupons = new ArrayList<>();
        coupons.addAll(decoratedRental.getAppliedCoupons());
        coupons.add("50%Off");
        return Collections.unmodifiableList(coupons);
    }
}
