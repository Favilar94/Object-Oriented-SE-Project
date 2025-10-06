package Movies;
public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }


    @Override
    public double getMovieRentalCost(int daysRented) {
        double thisAmount = 1.5;
        
        if(daysRented > 3){
            return thisAmount + ((daysRented - 3) * 1.5);
        }else{
            return thisAmount;
        }    
    }

    @Override
    public int getRewardPoints(int daysRented){
        return 1;
    }

}
