import Movies.Movie;

public class Rental {
    private Movie movie;
    private int   daysRented;
    private String movieTittle;

    public Rental(Movie movie, int daysRented) {
        this.movie      = movie;
        this.daysRented = daysRented;
        this.movieTittle = movie.getTitle();
    }
    
    public int getDaysRented() {
        return this.daysRented;
    }
    
    public Movie getMovie() {
        return this.movie;
    }

    public String getMovieTittle(){
        return this.movieTittle;
    }

    public double getRentalCost(){
        return this.movie.getMovieRentalCost(this.getDaysRented());
    }

    public int getRentalRewards(){
        return this.movie.getRewardPoints(this.getDaysRented());
    }
}