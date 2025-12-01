package app;

import java.time.LocalDate;

import movies.ChildrenMovie;
import movies.Movie;
import movies.RegularMovie;

import costs.purchase.ChildrenPurchaseCostStrategy;
import costs.purchase.NewReleasePurchaseCostStrategy;
import costs.purchase.RegularMoviePurchaseCostStrategy;
import costs.purchase.PurchaseCostStrategy;
import rewards.purchase.NewReleasePurchaseRewardStrategy;
import rewards.purchase.RegularPurchaseRewardStrategy;
import rewards.purchase.PurchaseRewardStrategy;

public class Purchase {
    private Movie movie;

    private PurchaseCostStrategy costStrategy;
    private PurchaseRewardStrategy rewardsStrategy;

    public Purchase(Movie movie) {
        this.movie = movie;
        this.assignStrategies();
    }


    private void assignStrategies() {
        if (this.isNewReleaseMovie()) {
            this.costStrategy = new NewReleasePurchaseCostStrategy();
            this.rewardsStrategy = new NewReleasePurchaseRewardStrategy();
        } else if (this.movie instanceof ChildrenMovie) {
            this.costStrategy = new ChildrenPurchaseCostStrategy();
            this.rewardsStrategy = new RegularPurchaseRewardStrategy();
        } else if (this.movie instanceof RegularMovie) {
            this.costStrategy = new RegularMoviePurchaseCostStrategy();
            this.rewardsStrategy = new RegularPurchaseRewardStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported movie type: " + movie.getClass());
        }
    }

    private boolean isNewReleaseMovie() {
        LocalDate release = this.movie.getReleaseDate();
        LocalDate today = LocalDate.now();
        boolean newReleaseMovie = release.isAfter(today.minusDays(30));
        return newReleaseMovie;
    }
    public Movie getMovie() {
        return this.movie;
    }


    public String getMovieTitle() {
        return this.movie.getTitle();
    }

    public double getPurchaseCost() {
        return this.costStrategy.getCost();

    }

    public int getPurchaseRewards(int customerAge) {
        return this.rewardsStrategy.getRewardPoints(customerAge);
    }

}
