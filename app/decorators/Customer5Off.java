package app.decorators;

import app.Customer;
import app.Transaction;

public class Customer5Off extends CustomerDecorator {
    private final Transaction decoratedTransaction;

    public Customer5Off(Customer customer) {
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

    @Override
    public java.util.List<String> getAppliedCoupons() {
        java.util.List<String> coupons = new java.util.ArrayList<>();
        coupons.addAll(super.getAppliedCoupons());

        if (this.decoratedTransaction.getRentals().size() > 5) {
            coupons.add("5Off");
        }

        return java.util.Collections.unmodifiableList(coupons);
    }
}
