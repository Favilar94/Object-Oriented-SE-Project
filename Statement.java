import java.util.ArrayList;

public final class Statement {
    
    public static void printStatement(Customer customer){
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<Rental>");
        System.out.println("    <CustomerName>" + customer.getCustomerName() + "</CustomerName>");

        System.out.println("    <Movies>");
        ArrayList<Rental> rentals = customer.getRentals();
        rentals.forEach((n) -> printMovie(n));
        System.out.println("    </Movies>");

        System.out.println("    <TotalOwed>" + customer.calculateOwedTotal() + "</TotalOwed>");
        System.out.println("    <RewardsPoints>" + customer.calculateRewardsTotal() + "</RewardsPoints>");
        System.out.println("</Rental>");

    }

    private static void printMovie(Rental rental) {
        System.out.println("        <Movie>");
        System.out.println("            <Name>" + rental.getMovieTittle() + "</Name>");
        System.out.println("            <DaysRented>" + rental.getDaysRented() + "</DaysRented>");
        System.out.println("            <Price>" + rental.getRentalCost() + "</Price>");
        System.out.println("        </Movie>");
    }

}
