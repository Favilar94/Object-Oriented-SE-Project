package app;
import java.time.LocalDate;

import costs.ChildrenCostStrategy;
import costs.CostStrategy;
import costs.NewReleaseCostStrategy;
import costs.RegularMovieCostStrategy;
import movies.ChildrenMovie;
import movies.Movie;
import movies.RegularMovie;
import rewards.NewReleaseRewardStrategy;
import rewards.RegularRewardStrategy;
import rewards.RewardStrategy;

public class Rental {
    private Movie movie;
    private int daysRented;

    private CostStrategy costStrategy;
    private RewardStrategy rewardsStrategy;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.assignStrategies();

    }

    private void assignStrategies() {
        if (this.isNewReleaseMovie()) {
            this.costStrategy = new NewReleaseCostStrategy();
            this.rewardsStrategy = new NewReleaseRewardStrategy();
        } else if (this.movie instanceof ChildrenMovie) {
            this.costStrategy = new ChildrenCostStrategy();
            this.rewardsStrategy = new RegularRewardStrategy();
        } else if (this.movie instanceof RegularMovie) {
            this.costStrategy = new RegularMovieCostStrategy();
            this.rewardsStrategy = new RegularRewardStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported movie type: " + movie.getClass());
        }
    }
    
    private boolean isNewReleaseMovie() {
        LocalDate release = this.movie.getReleaseDate();
        LocalDate today = LocalDate.now();
        boolean newReleaseMovie = release.isAfter(today.plusDays(-30));
        return newReleaseMovie;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public String getMovieTitle() {
        return this.movie.getTitle();
    }

    public double getRentalCost() {
        return this.costStrategy.getMovieRentalCost(this.getDaysRented());
    }

    public int getRentalRewards(int customerAge) {
        return this.rewardsStrategy.getRewardPoints(this.getDaysRented(), customerAge);
    }
}