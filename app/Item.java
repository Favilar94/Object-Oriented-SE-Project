package app;
import rewards.purchase.PurchaseRewardStrategy;
import rewards.rental.RentalRewardStrategy;

import costs.purchase.PurchaseCostStrategy;
import costs.rental.RentalCostStrategy;


import java.time.LocalDate;

import items.ItemOperation;

public abstract class Item {
    
    public String title;
    public LocalDate releaseDate;

    public RentalCostStrategy rentalCostStrategy;
    public RentalRewardStrategy rentalRewardsStrategy;
    public PurchaseCostStrategy pruchaseCostStrategy;
    public PurchaseRewardStrategy pruchaseRewardsStrategy;

    public Item(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return this.title;
    }
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }

    public boolean isNewRelease() {
        if(this.releaseDate == null) {
            return false;
        }else{
            LocalDate today = LocalDate.now();
            boolean newReleaseMovie = this.releaseDate.isAfter(today.minusDays(30));
            return newReleaseMovie;
        }
    }
    
    public abstract String getItemType();

    public abstract void assignStrategies(ItemOperation operation);

}
