package app;
import rewards.purchase.PurchaseRewardStrategy;
import rewards.rental.RentalRewardStrategy;

import costs.purchase.PurchaseCostStrategy;
import costs.rental.RentalCostStrategy;


import java.time.LocalDate;

import items.ItemOperation;

public abstract class Item {
    
    private String title;
    private LocalDate releaseDate;

    private Boolean isRentable =false;
    public RentalCostStrategy rentalCostStrategy;
    public RentalRewardStrategy rentalRewardsStrategy;

    private Boolean isPurchasable = false;
    public PurchaseCostStrategy purchaseCostStrategy;
    public PurchaseRewardStrategy purchaseRewardsStrategy;

    public Item(String title, LocalDate releaseDate, Boolean isRentable, Boolean isPurchasable) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.isRentable = isRentable;
        this.isPurchasable = isPurchasable;
    }


    public Boolean getIsRentable() {
        return isRentable;
    }
    public Boolean getIsPurchasable(){
        return isPurchasable;
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

    public double getRentalCost(int daysRented) {
        if (this.rentalCostStrategy == null || this.isRentable) {
            throw new IllegalStateException("rentalCostStrategy not assigned for item: " + this.title);
        }
        return this.rentalCostStrategy.getCost(daysRented);
    }

    public double getPurchaseCost() {
        if (this.purchaseCostStrategy == null || this.isPurchasable) {
            throw new IllegalStateException("purchaseCostStrategy not assigned for item: " + this.title);
        }
        return this.purchaseCostStrategy.getCost(this.getItemType());
    }

    public int getRentalRewards(int daysRented, int customerAge) {
        if (this.rentalRewardsStrategy == null || this.isRentable) {
            throw new IllegalStateException("rentalRewardsStrategy not assigned for item: " + this.title);
        }
        return this.rentalRewardsStrategy.getRewardPoints(daysRented, customerAge);
    }

    public int getPurchaseRewards(int customerAge) {
        if (this.purchaseRewardsStrategy == null || this.isPurchasable) {
            throw new IllegalStateException("purchaseRewardsStrategy not assigned for item: " + this.title);
        }
        return this.purchaseRewardsStrategy.getRewardPoints(customerAge);
    }

}
