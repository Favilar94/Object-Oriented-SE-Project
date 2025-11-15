package app;
import java.util.List;

public class Customer {
    private String customerName;
    private int age;
    private Transaction transaction;
    private int rewardsPoints;

    public Customer(Transaction transaction, String name, int age, int rewardsPoints) {
        this.transaction = transaction;
        this.customerName = name;
        this.age = age;
        this.rewardsPoints = rewardsPoints;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public void setCustomerName(String name) {
        this.customerName = name;
    }  

    public int getCustomerAge() {
        return this.age;
    }
    public void setCustomerAge(int age) {
        this.age = age;
    }

    public Transaction getTransaction() {
        return this.transaction;
    } 

    public List<Rental> getRentals() {
        return transaction.getRentals();
    }

    public double calculateOwedTotal() {

        return this.transaction.calculateOwedTotal();
    }

    public int calculateRewardsTotal() {
        this.rewardsPoints += this.transaction.calculateRewardsTotal(getCustomerAge());
        return this.rewardsPoints;
    }

    public void setRewardsPoints(int points) {
        this.rewardsPoints = points;
    }
    public int getRewardsPoints() {
        return this.rewardsPoints;
    }   
}