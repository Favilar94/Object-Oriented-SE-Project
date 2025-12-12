package app.decorators;

import app.Rental;

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
}
