package app.decorators;

import app.Customer;
import app.Rental;
import app.Transaction;
import items.Movie;
import java.util.List;

//Free movie rental if customer rents 5 or more movies
public class CustomerFreeMovie extends CustomerDecorator{
    private final Transaction decoratedTransaction;

    public CustomerFreeMovie(Customer customer) {
        super(customer);
        this.decoratedTransaction = customer.getTransaction();
    }

    @Override
    public double calculateOwedTotal() {
        double total = this.decoratedCustomer.calculateOwedTotal();

        List<Rental> rentals = this.decoratedTransaction.getRentals();
        int movieCount = 0;
        double cheapestMovieCost = Double.POSITIVE_INFINITY;

        for (Rental r : rentals) {
            if (r.getItem() instanceof Movie) {
                movieCount++;
                double cost = r.getRentalCost();
                if (cost < cheapestMovieCost) {
                    cheapestMovieCost = cost;
                }
            }
        }

        if (movieCount >= 5 && cheapestMovieCost != Double.POSITIVE_INFINITY) {
            return Math.max(0, total - cheapestMovieCost);
        } else {
            return total;
        }
    }

    @Override
    public java.util.List<String> getAppliedCoupons() {
        java.util.List<String> coupons = new java.util.ArrayList<>();
        coupons.addAll(super.getAppliedCoupons());

        java.util.List<Rental> rentals = this.decoratedTransaction.getRentals();
        int movieCount = 0;
        double cheapestMovieCost = Double.POSITIVE_INFINITY;

        for (Rental r : rentals) {
            if (r.getItem() instanceof Movie) {
                movieCount++;
                double cost = r.getRentalCost();
                if (cost < cheapestMovieCost) {
                    cheapestMovieCost = cost;
                }
            }
        }

        if (movieCount >= 5 && cheapestMovieCost != Double.POSITIVE_INFINITY) {
            coupons.add("FreeMovie");
        }

        return java.util.Collections.unmodifiableList(coupons);
    }
}
