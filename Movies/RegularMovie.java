package Movies;
public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getMovieRentalCost(int daysRented) {
        double thisAmount = 2;
        if(daysRented > 2){
            return thisAmount + ((daysRented - 2) * 1.5);
        }else{
            return thisAmount;
        }    
    }

   @Override
    public int getRewardPoints(int daysRented){
        return 1;
    }
}
