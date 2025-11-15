package app.decorators;

import app.Rental;

public class Rental50PercentOff extends Rental {
    private Rental decoratedRental;

    public Rental50PercentOff(Rental rental) {
        super(rental.getMovie(), rental.getDaysRented());
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        super.appliedDiscount = true;
        super.originalPrice = decoratedRental.getRentalCost();

        return decoratedRental.getRentalCost() * 0.5;
    }

    @Override
    public int getRentalRewards(int customerAge) {
        return decoratedRental.getRentalRewards(customerAge);
    }
}
