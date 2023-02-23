public class Ticket {
    // create attributes row, seat, price, and Person (Object from class Person)
    private int row;
    private int seat;
    private double price;
    private Person person;

    // constructor
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // create getters
    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }
    public double getPrice() {
        return price;
    }

    // create methods to print the ticket
    public void print() {
        // print ticket with Person name, Person surname, Person email, row, seat, and price.
        System.out.println("Ticket: \nName: " + person.getName() + " " + person.getSurname() + "\nEmail: " + person.getEmail() + "\nRow No. " + row + " \nSeat No. " + seat + "\nPrice: " + price + "£");
    }

    
}
