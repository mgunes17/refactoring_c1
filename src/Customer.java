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

    public String htmlStatement() {
        Enumeration _rentals = rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

        while (_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();

            //show figures for each rental
            result += each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";

        result += "On this rental you earned <EM>" + String.valueOf(
                    getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        
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
