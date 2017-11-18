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
        Enumeration eRentals = rentals.elements();
        String result = "REntal record for " + getName() + "\n";

        while(eRentals.hasMoreElements()) {
            Rental each = (Rental) eRentals.nextElement();


            //show figures for this rental
            result += "\t" + each.getMovie().getPriceCode() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owd is " + String.valueOf(getTotalCharge()) + "\n";
        result += "you earned" + String.valueOf(getTotalFrequentRenterPoints()) + "frequest renter points";

        return result;
    }

    private double getTotalCharge() {
        double result = 0;

        Enumeration _rentals = rentals.elements();

        while(_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration _rentals = rentals.elements();

        while (_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }


}
