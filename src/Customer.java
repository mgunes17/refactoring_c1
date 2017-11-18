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
            double thisAmount = 0;
            Rental each = (Rental) eRentals.nextElement();

            thisAmount = amountFor(each);

            frequentRenterPoints++;

            //add bonus for a two day new rlease rental
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.getMovie().getPriceCode() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += totalAmount;
        }

        //add footer lines
        result += "Amount owd is " + String.valueOf(totalAmount) + "\n";
        result += "you earned" + String.valueOf(frequentRenterPoints) + "frequest renter points";

        return result;
    }

    private double amountFor(Rental aREntal) {
        double result = 0;

        switch (aREntal.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;

                if(aREntal.getDaysRented() > 2)
                    result += (aREntal.getDaysRented() - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                result += aREntal.getDaysRented() * 3;
                break;

            case Movie.CHILDRENS:
                result += 1.5;

                if(aREntal.getDaysRented() > 3)
                    result += (aREntal.getDaysRented() - 3) * 1.5;
                break;
        }

        return result;
    }
}
