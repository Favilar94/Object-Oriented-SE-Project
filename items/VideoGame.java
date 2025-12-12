package items;

import java.time.LocalDate;

import app.Item;
import costs.purchase.VideoGamePurchaseCostStrategy;
import rewards.purchase.VideoGamePurchaseRewardStrategy;

import costs.rental.VideoGameRentalCostStrategy;
import rewards.rental.VideoGameRentalRewardStrategy;

public class VideoGame extends Item{

    private Version version;

    public VideoGame(String title, LocalDate releaseDate, Version version) {
        super(title, releaseDate, true, true);
        this.version = version;
    }

    public Version getVersion() {
        return this.version;
    }

    @Override
    public void assignStrategies(ItemOperation operation) {
        if (operation == ItemOperation.RENT){
            if (this.getVersion() == Version.STANDARD) {
                this.rentalCostStrategy = new VideoGameRentalCostStrategy();
                this.rentalRewardsStrategy = new VideoGameRentalRewardStrategy();
            } else {
                throw new IllegalArgumentException("Unsupported version type: " + getClass());
            }
        }
        else if(operation == ItemOperation.PURCHASE) {
            if (this.getVersion() == Version.STANDARD) {
                this.purchaseCostStrategy = new VideoGamePurchaseCostStrategy();
                this.purchaseRewardsStrategy = new VideoGamePurchaseRewardStrategy();
            } else {
                throw new IllegalArgumentException("Unsupported version type: " + getClass());
            }
        }else{
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }

    @Override
    public String getItemType() {
        return version.toString();
    }

}
