package app.decorators;

import app.Rental;

public class Rental1Off extends Rental {
    private Rental decoratedRental;

    public Rental1Off(Rental rental) {
        super(rental.getMovie(), rental.getDaysRented());
        this.decoratedRental = rental;
    }

    @Override
    public double getRentalCost() {
        double originalPrice = decoratedRental.getRentalCost();
        if(originalPrice > 5.0){
            super.appliedDiscount = true;
            super.originalPrice = originalPrice;
            return Math.max(0, originalPrice - 1.0) ;
        }else{
            return originalPrice;
        }
    }

    @Override
    public int getRentalRewards(int customerAge) {
        return decoratedRental.getRentalRewards(customerAge);
    }
}
