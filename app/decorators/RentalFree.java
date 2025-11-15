package app.decorators;

import app.Rental;

public class RentalFree extends RentalDecorator{

    public RentalFree(Rental rental) {
        super(rental);
    }

    @Override
    public double getRentalCost() {
        return 0.0;
    }
}
