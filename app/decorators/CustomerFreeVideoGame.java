package app.decorators;

import java.util.List;

import app.Customer;
import app.Item;
import app.Purchase;
import app.Transaction;
import items.Playstation;
import items.VideoGame;

//Free video game purchase if customer purchases a Playstation console
public class CustomerFreeVideoGame extends CustomerDecorator {
    private final Transaction decoratedTransaction;

    public CustomerFreeVideoGame(Customer customer) {
        super(customer);
        this.decoratedTransaction = customer.getTransaction();
    }

    @Override
    public double calculateOwedTotal() {
        double total = this.decoratedCustomer.calculateOwedTotal();

        List<Purchase> purchases = this.decoratedTransaction.getPurchases();
        double cheapestVideoGameCost = Double.POSITIVE_INFINITY;
        boolean playstationPurchase = false;

        for (Purchase p : purchases) {
            Item item = p.getItem();
            if (item instanceof Playstation) {
                playstationPurchase = true;
            }
            else if (item instanceof VideoGame) {
                double cost = p.getPurchaseCost();
                if (cost < cheapestVideoGameCost) {
                    cheapestVideoGameCost = cost;
                }
            }
        }

        if (playstationPurchase && cheapestVideoGameCost != Double.POSITIVE_INFINITY) {
            return Math.max(0, total - cheapestVideoGameCost);
        } else {
            return total;
        }
    }

    
}
