package rewards.rental;

public class NewReleaseRentalRewardStrategy implements RentalRewardStrategy{
    @Override
    public int getRewardPoints(int daysRented, int customerAge){
        
        if(daysRented > 2 && customerAge >=18 && customerAge <=22){
            return 5;
        }
        else if(daysRented > 1){
            return 2;
        }
        else{
            return 1;
        }
    }
}
