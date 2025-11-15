package app.decorators;

import app.Rental;


public abstract class RentalDecorator extends Rental {
	protected final Rental decoratedRental;

	public RentalDecorator(Rental rental) {
		super(rental.getMovie(), rental.getDaysRented());
		this.decoratedRental = rental;
	}

}
