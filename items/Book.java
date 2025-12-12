package items;

import java.time.LocalDate;

import app.Item;

public class Book extends Item{

    private BookType BookType;
    public Book(String title, LocalDate releaseDate, BookType BookType) {
        super(title, releaseDate, false, true);
        this.BookType = BookType;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {
        if (operation == ItemOperation.PURCHASE) {
            this.purchaseCostStrategy = new costs.purchase.BookPurchaseCostStrategy();
            this.purchaseRewardsStrategy = new rewards.purchase.BookPurchaseRewardStrategy();
        } 
        else{
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
    
    @Override
    public String getItemType() {
        return BookType.toString();
    }
    
}
