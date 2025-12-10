package app;
import items.ItemOperation;


public class Rental {
    private Item item;
    private int daysRented;

    public Rental(Item item, int daysRented) {
        if(! (item instanceof app.Rentable)) {
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
        return this.item.rentalCostStrategy.getCost(this.getDaysRented());
    }

    public int getRentalRewards(int customerAge) {
        return this.item.rentalRewardsStrategy.getRewardPoints(this.getDaysRented(), customerAge);
    }

}