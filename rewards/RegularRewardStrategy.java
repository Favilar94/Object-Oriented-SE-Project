package rewards;

public class RegularRewardStrategy implements RewardStrategy{
    @Override
    public int getRewardPoints(int daysRented, int customerAge){
        return 1;
    }

}
