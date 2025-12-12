package app;
import items.ItemOperation;
import java.util.Collections;
import java.util.List;


public class Rental {
    private Item item;
    private int daysRented;

    public Rental(Item item, int daysRented) {
        if(!item.getIsRentable()) {
            throw new IllegalArgumentException("Item is not rentable: " + item);
        }
        this.item = item;
        this.daysRented = daysRented;
        this.item.assignStrategies(ItemOperation.RENT);

    }


    public int getDaysRented() {
        return this.daysRented;
    }

    public Item getItem() {
        return this.item;
    }

    public String getItemTitle() {
        return this.item.getTitle();
    }

    public double getRentalCost() {
        return this.item.getRentalCost(this.getDaysRented());
    }

    public double getOriginalRentalCost() {
        return this.item.getRentalCost(this.getDaysRented());
    }

    public List<String> getAppliedCoupons() {
        return Collections.emptyList();
    }

    public int getRentalRewards(int customerAge) {
        return this.item.getRentalRewards(this.getDaysRented(), customerAge);
    }

}