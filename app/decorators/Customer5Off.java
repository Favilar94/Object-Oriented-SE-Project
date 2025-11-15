package app.decorators;

import app.Customer;
import app.Transaction;

public class Customer5Off extends Customer {
    Transaction decoratedTransaction;

    public Customer5Off(Customer Customer) {
        super(Customer.getTransaction(), Customer.getCustomerName(), Customer.getCustomerAge());

        this.decoratedTransaction = Customer.getTransaction();
    }

    @Override
    public double calculateOwedTotal() {
        double total = super.calculateOwedTotal();

        if(decoratedTransaction.getRentals().size() > 5){
            return Math.max(0, total - 5.0);
        } else {
            return total;
        }
    }
}
