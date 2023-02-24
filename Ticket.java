public class Ticket {
    // instance variables
    private int seatNumber; // seat number
    private int rowNumber; // row number
    private double ticketPrice; // ticket price
    private Person ticketHolder; // ticket holder

    // constructor
    public Ticket(int row, int seat, double price, Person person) {
        // set the instance variables
        rowNumber = row; // set the row number
        seatNumber = seat; // set the seat number
        ticketPrice = price; // set the ticket price
        ticketHolder = person; // set the ticket holder
    }

    // getters
    public int getRowNumber() {
        return rowNumber; // return the row number
    }

    public int getSeatNumber() {
        return seatNumber; // return the seat number
    }

    public double getTicketPrice() {
        return ticketPrice; // return the ticket price
    }

    // print ticket method
    public void print() {
        // print the ticket with the person's name, surname, email, row number, seat
        // number and ticket price
        System.out.println("Movie Ticket: \nName: " + ticketHolder.getName() + " " + ticketHolder.getSurname()
                + "\nEmail: " + ticketHolder.getEmail() + "\nRow Number: " + rowNumber + " \nSeat Number: " + seatNumber
                + "\nTicket Price: " + ticketPrice + "£");
    }
}