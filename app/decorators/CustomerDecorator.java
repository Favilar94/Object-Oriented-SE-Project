package app.decorators;

import app.Customer;


public abstract class CustomerDecorator extends Customer {
    protected final Customer decoratedCustomer;

    public CustomerDecorator(Customer decoratedCustomer) {
        super(decoratedCustomer.getTransaction(), decoratedCustomer.getCustomerName(), decoratedCustomer.getCustomerAge());
        this.decoratedCustomer = decoratedCustomer;
    }

}
