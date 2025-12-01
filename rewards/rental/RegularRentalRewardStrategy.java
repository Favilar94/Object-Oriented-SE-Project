package rewards.rental;

public class RegularRentalRewardStrategy implements RentalRewardStrategy{
    @Override
    public int getRewardPoints(int daysRented, int customerAge){
        return 1;
    }

}
