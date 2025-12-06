package app;
import java.time.LocalDate;

import costs.rental.ChildrenRentalCostStrategy;
import costs.rental.RentalCostStrategy;
import costs.rental.NewReleaseRentalCostStrategy;
import costs.rental.RegularMovieRentalCostStrategy;
import movies.Movie;
import movies.MovieTypes;
import rewards.rental.NewReleaseRentalRewardStrategy;
import rewards.rental.RegularRentalRewardStrategy;
import rewards.rental.RentalRewardStrategy;

public class Rental {
    private Movie movie;
    private int daysRented;

    private RentalCostStrategy costStrategy;
    private RentalRewardStrategy rewardsStrategy;
    

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.assignStrategies();

    }

    private void assignStrategies() {
        if (this.isNewReleaseMovie()) {
            this.costStrategy = new NewReleaseRentalCostStrategy();
            this.rewardsStrategy = new NewReleaseRentalRewardStrategy();
        } else if (this.movie.getMovieType() == MovieTypes.CHILDREN) {
            this.costStrategy = new ChildrenRentalCostStrategy();
            this.rewardsStrategy = new RegularRentalRewardStrategy();
        } else if (this.movie.getMovieType() == MovieTypes.REGULAR) {
            this.costStrategy = new RegularMovieRentalCostStrategy();
            this.rewardsStrategy = new RegularRentalRewardStrategy();
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
        return this.costStrategy.getCost(this.getDaysRented());
    }

    public int getRentalRewards(int customerAge) {
        return this.rewardsStrategy.getRewardPoints(this.getDaysRented(), customerAge);
    }

}