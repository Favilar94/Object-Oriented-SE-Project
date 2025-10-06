package Movies;
public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getMovieRentalCost(int daysRented) {
        return daysRented * 3;
    }

   @Override
    public int getRewardPoints(int daysRented){
        if(daysRented > 1){
            return 2;
        }
        else{
            return 1;
        }
    }
}
