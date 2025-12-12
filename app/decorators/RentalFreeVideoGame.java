package app.decorators;

import app.Rental;
import items.VideoGame;

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
}
