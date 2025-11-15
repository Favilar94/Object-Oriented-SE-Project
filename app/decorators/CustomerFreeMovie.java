package app.decorators;

import app.Customer;
import app.Transaction;

public class CustomerFreeMovie extends CustomerDecorator{
        private final Transaction decoratedTransaction;

    public CustomerFreeMovie(Customer customer) {
        super(customer);
        this.decoratedTransaction = customer.getTransaction();
    }

    @Override
    public double calculateOwedTotal() {
        double total = this.decoratedCustomer.calculateOwedTotal();

        if (this.decoratedTransaction.getRentals().size() > 5) {
            return Math.max(0, total - 5.0);
        } else {
            return total;
        }
    }
}
