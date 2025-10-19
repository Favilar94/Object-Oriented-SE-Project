package rewards;

public interface RewardStrategy{
    int getRewardPoints(int daysRented, int customerAge);
}
