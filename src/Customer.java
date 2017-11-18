import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration eRentals = rentals.elements();
        String result = "REntal record for " + getName() + "\n";

        while(eRentals.hasMoreElements()) {
            Rental each = (Rental) eRentals.nextElement();

            frequentRenterPoints++;

            //add bonus for a two day new rlease rental
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.getMovie().getPriceCode() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        //add footer lines
        result += "Amount owd is " + String.valueOf(totalAmount) + "\n";
        result += "you earned" + String.valueOf(frequentRenterPoints) + "frequest renter points";

        return result;
    }
}
