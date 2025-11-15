package app.decorators;

import app.Rental;

public class Rental1Off extends RentalDecorator {
    private final Rental decoratedRental;

    public Rental1Off(Rental rental) {
        super(rental);
        this.decoratedRental = rental;

    }

    @Override
    public double getRentalCost() {

        double originalPrice = this.decoratedRental.getRentalCost();
        boolean applyDiscount = originalPrice > 5.0;

        if (applyDiscount) {
            return Math.max(0, originalPrice - 1.0);
        } else {
            return originalPrice;
        }
    }

    @Override
    public int getRentalRewards(int customerAge) {
        return decoratedRental.getRentalRewards(customerAge);
    }

}
