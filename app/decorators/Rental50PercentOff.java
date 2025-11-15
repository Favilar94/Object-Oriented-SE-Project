package app.decorators;

import app.Rental;

public class Rental50PercentOff extends RentalDecorator{
    private final Rental decoratedRental;

    public Rental50PercentOff(Rental rental) {
        super(rental);
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        double originalPrice = this.decoratedRental.getRentalCost();
        return originalPrice * 0.5;
    }

    @Override
    public int getRentalRewards(int customerAge) {
        return decoratedRental.getRentalRewards(customerAge);
    }

}
