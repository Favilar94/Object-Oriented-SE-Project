package app.decorators;
import app.Rental;
import items.Movie;

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
}
