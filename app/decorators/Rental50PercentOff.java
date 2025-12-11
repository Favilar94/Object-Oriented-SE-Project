package app.decorators;

import app.Rental;
import items.Movie;

public class Rental50PercentOff extends RentalDecorator{
    private final Rental decoratedRental;

    public Rental50PercentOff(Rental rental) {
        super(rental);
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        var item = decoratedRental.getItem();
        if(item instanceof Movie){
            return this.decoratedRental.getRentalCost() * 0.5;
        }
        return this.decoratedRental.getRentalCost();
    }
}
