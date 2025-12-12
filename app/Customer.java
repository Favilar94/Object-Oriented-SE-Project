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

    public List<Purchase> getPurchases() {
        return transaction.getPurchases();
    }


    public double calculateOwedTotal() {

        return this.transaction.calculateOwedTotal();
    }

    public int calculateRewardsTotal() {
        return this.transaction.calculateRewardsTotal(getCustomerAge());
    }

    public void finishTransaction() {
        this.rewardsPoints += this.calculateRewardsTotal();
    }

    public int getRewardsPoints() {
        return this.rewardsPoints;
    }   

    public java.util.List<String> getAppliedCoupons() {
        return java.util.Collections.emptyList();
    }
}