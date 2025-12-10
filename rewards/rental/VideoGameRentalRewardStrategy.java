package rewards.rental;

public class VideoGameRentalRewardStrategy implements RentalRewardStrategy{
    @Override
    public int getRewardPoints(int daysRented, int customerAge) {
        return daysRented;
    }
}
