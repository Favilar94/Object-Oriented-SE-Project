package app.decorators;

import app.Transaction;

public class Transaction5DollarOff extends TransactionDecorator{
    private final Transaction transaction;
    public Transaction5DollarOff(Transaction transaction){
        super(transaction);
        this.transaction = transaction;
    }

    @Override
    public double calculateOwedTotal() {

        if((long) this.transaction.getRentals().size() > 5){
            return transaction.calculateOwedTotal() - 5;
        }
        return transaction.calculateOwedTotal();
    }
}
