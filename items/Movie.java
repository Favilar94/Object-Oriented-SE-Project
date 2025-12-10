package items;

import java.time.LocalDate;

import app.Item;
import costs.purchase.ChildrenPurchaseCostStrategy;
import costs.purchase.NewReleasePurchaseCostStrategy;
import costs.purchase.RegularMoviePurchaseCostStrategy;
import costs.rental.ChildrenRentalCostStrategy;
import costs.rental.NewReleaseRentalCostStrategy;
import costs.rental.RegularMovieRentalCostStrategy;
import rewards.purchase.NewReleasePurchaseRewardStrategy;
import rewards.purchase.RegularPurchaseRewardStrategy;
import rewards.rental.NewReleaseRentalRewardStrategy;
import rewards.rental.RegularRentalRewardStrategy;

public class Movie extends Item implements app.Rentable, app.Purchasable {

    private MovieType movieType;

    public Movie(String title, MovieType type, LocalDate releaseDate) {
        super(title, releaseDate);
        this.movieType = type;
    }

    public MovieType getMovieType() {
        return this.movieType;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {


        if(operation == ItemOperation.PURCHASE) {
            if (super.isNewRelease()) {
                this.pruchaseCostStrategy = new NewReleasePurchaseCostStrategy();
                this.pruchaseRewardsStrategy = new NewReleasePurchaseRewardStrategy();
            } else if (this.getMovieType() == MovieType.CHILDREN) {
                this.pruchaseCostStrategy = new ChildrenPurchaseCostStrategy();
                this.pruchaseRewardsStrategy = new RegularPurchaseRewardStrategy();
            } else if (this.getMovieType() == MovieType.REGULAR) {
                this.pruchaseCostStrategy = new RegularMoviePurchaseCostStrategy();
                this.pruchaseRewardsStrategy = new RegularPurchaseRewardStrategy();
            } else {
                throw new IllegalArgumentException("Unsupported movie type: " + getClass());
            }
        }
        else if (operation == ItemOperation.RENT) {
            if (super.isNewRelease()) {
                this.rentalCostStrategy = new NewReleaseRentalCostStrategy();
                this.rentalRewardsStrategy = new NewReleaseRentalRewardStrategy();
            } else if (this.getMovieType() == MovieType.CHILDREN) {
                this.rentalCostStrategy = new ChildrenRentalCostStrategy();
                this.rentalRewardsStrategy = new RegularRentalRewardStrategy();
            } else if (this.getMovieType() == MovieType.REGULAR) {
                this.rentalCostStrategy = new RegularMovieRentalCostStrategy();
                this.rentalRewardsStrategy = new RegularRentalRewardStrategy();
            } else {
                throw new IllegalArgumentException("Unsupported movie type: " + getClass());
            }
        }else{
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

    }

    @Override
    public String getItemType() {
        return movieType.toString();
    }
}
