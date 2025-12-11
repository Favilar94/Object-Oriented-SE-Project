package app.decorators;

import app.Transaction;

public class TransactionDecorator extends Transaction {
    public TransactionDecorator(Transaction transaction){
        super(transaction.getRentals(), transaction.getPurchases());
    }
}
