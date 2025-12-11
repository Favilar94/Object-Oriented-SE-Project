package app.decorators;

import app.Rental;


public abstract class RentalDecorator extends Rental {
	public RentalDecorator(Rental rental) {
		super(rental.getItem(), rental.getDaysRented());
	}

}
