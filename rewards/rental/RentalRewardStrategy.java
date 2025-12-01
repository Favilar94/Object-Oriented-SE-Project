package rewards.rental;

public interface RentalRewardStrategy{
    int getRewardPoints(int daysRented, int customerAge);
}
