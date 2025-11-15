package app;
import java.util.ArrayList;

public class Customer {
    private String customerName;
    private int age;
    private Transaction transaction;

    public Customer(Transaction transaction, String name, int age) {
        this.transaction = transaction;
        this.customerName = name;
        this.age = age;
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

    public ArrayList<Rental> getRentals() {
        return transaction.getRentals();
    }

    public double calculateOwedTotal() {

        return this.transaction.calculateOwedTotal();
    }

    public int calculateRewardsTotal() {
        return this.transaction.calculateRewardsTotal(getCustomerAge());
    }
}