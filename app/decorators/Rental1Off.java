package app.decorators;

import app.Rental;
import items.Movie;

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

        if(decoratedRental.getItem() instanceof Movie){
            return decoratedRental.getRentalCost() > 5 ? decoratedRental.getRentalCost() - 1 : decoratedRental.getRentalCost();
        }
        return decoratedRental.getRentalCost();
    }
}
