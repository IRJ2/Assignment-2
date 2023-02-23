import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// create class theatre
public class Theatre {
    // create 3 arrays row1, row2,and row3 with size 12, 16,and 20
    char[] row1 = new char[12];
    char[] row2 = new char[16];
    char[] row3 = new char[20];
    // create array list of tickets to save all the Tickets
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    // constructor to initialize arrays with 0
    public Theatre() {
        for (int i = 0; i < row1.length; i++) {
            row1[i] = 'O';
        }
        for (int i = 0; i < row2.length; i++) {
            row2[i] = 'O';
        }
        for (int i = 0; i < row3.length; i++) {
            row3[i] = 'O';
        }
    }

    // create method buy_ticket
    public void buy_ticket() {
        // create a scanner object
        Scanner input = new Scanner(System.in);
        // get the information of a Person
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter surname: ");
        String surname = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        // create a Person object
        Person person = new Person(name, surname, email);
        // get the row and seat number
        // prompt user to enter a row number
        System.out.print("Enter row number: ");
        // store user input in variable
        int row = input.nextInt();
        // prompt user to enter a seat number
        System.out.print("Enter seat number: ");
        // store user input in variable
        int seat = input.nextInt();
        // create flag variable to check if seat is available
        boolean flag = false;
        // create a switch statement to perform different actions based on user input
        switch (row) {
            // if user enters 1
            case 1:
                // check if seat is available
                if (row1[seat - 1] == 'O') {
                    // display message
                    System.out.println("Ticket purchased");
                    // set seat to X
                    row1[seat - 1] = 'X';
                    flag = true; // seat is available
                } else {
                    // if seat is not available display error message
                    System.out.println("Seat is not available");
                }
                break;
            // if user enters 2
            case 2:
                // check if seat is available
                if (row2[seat - 1] == 'O') {
                    // display message
                    System.out.println("Ticket purchased");
                    // set seat to X
                    row2[seat - 1] = 'X';
                    flag = true; // seat is available
                } else {
                    // if seat is not available display error message
                    System.out.println("Seat is not available");
                }
                break;
            // if user enters 3
            case 3:
                // check if seat is available
                if (row3[seat - 1] == 'O') {
                    // display message
                    System.out.println("Ticket purchased");
                    // set seat to X
                    row3[seat - 1] = 'X';
                    flag = true; // seat is available
                } else {
                    // if seat is not available display error message
                    System.out.println("Seat is not available");
                }
                break;
            // if user enters any other number display error message
            default:
                System.out.println("Invalid input");
        }
        // if seat is available
        if (flag) {
            // let the price of ticket in row1, row2,and row3 is 10£, 20£,and 30£
            int price = 0;
            // create a switch statement to find the price of ticket purchased
            switch (row) {
                // if user enters 1
                case 1:
                    price = 10; // set price to 10
                    break;
                // if user enters 2
                case 2:
                    price = 20; // set price to 20
                    break;
                // if user enters 3
                case 3:
                    price = 30; // set price to 30
                    break;
            }
            // create a Ticket object
            Ticket ticket = new Ticket(row, seat, price, person);
            // add ticket to the array list
            tickets.add(ticket);
        }
    }

    // create method print_seating_area
    public void print_seating_area() {
        // print each row in a pyramid pattern
        // print stage
        System.out.print("    ***********\n     * STAGE *\n    ***********\n");
        int space = 4; // variable to store number of spaces
        // iterate through each row
        for (int i = 0; i < 3; i++) {
            // print spaces
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            // decrement space by 2
            space -= 2;
            // print half length of row1 when i = 0
            if (i == 0) {
                for (int j = 0; j < row1.length / 2; j++) {
                    System.out.print(row1[j]);
                }
                System.out.print(" ");
                // print other half of row1
                for (int j = row1.length / 2; j < row1.length; j++) {
                    System.out.print(row1[j]);
                }
            }
            // print half length of row2 when i = 1
            if (i == 1) {
                for (int j = 0; j < row2.length / 2; j++) {
                    System.out.print(row2[j]);
                }
                System.out.print(" ");
                // print other half of row2
                for (int j = row2.length / 2; j < row2.length; j++) {
                    System.out.print(row2[j]);
                }
            }
            // print half length of row3 when i = 2
            if (i == 2) {
                for (int j = 0; j < row3.length / 2; j++) {
                    System.out.print(row3[j]);
                }
                System.out.print(" ");
                // print other half of row3
                for (int j = row3.length / 2; j < row3.length; j++) {
                    System.out.print(row3[j]);
                }
            }
            // print new line
            System.out.println();
        }
    }

    // create method cancel_ticket
    public void cancel_ticket() {
        // create a scanner object
        Scanner input = new Scanner(System.in);
        // prompt user to enter a row number
        System.out.print("Enter row number: ");
        // store user input in variable
        int row = input.nextInt();
        // prompt user to enter a seat number
        System.out.print("Enter seat number: ");
        // store user input in variable
        int seat = input.nextInt();
        // create a flag variable to check if ticket is cancelled
        boolean flag = false;
        // create a switch statement to perform different actions based on user input
        switch (row) {
            // if user enters 1
            case 1:
                // display message
                System.out.println("Ticket cancelled");
                // set seat to O
                row1[seat - 1] = 'O';
                flag = true; // ticket is cancelled
                break;
            // if user enters 2
            case 2:
                // display message
                System.out.println("Ticket cancelled");
                // set seat to O
                row2[seat - 1] = 'O';
                flag = true; // ticket is cancelled
                break;
            // if user enters 3
            case 3:
                // display message
                System.out.println("Ticket cancelled");
                // set seat to O
                row3[seat - 1] = 'O';
                flag = true; // ticket is cancelled
                break;
            // if user enters any other number display error message
            default:
                System.out.println("Invalid input");
        }
        // if ticket is cancelled
        if (flag) {
            // iterate through the array list
            for (int i = 0; i < tickets.size(); i++) {
                // if row and seat number matches
                if (tickets.get(i).getRow() == row && tickets.get(i).getSeat() == seat) {
                    // remove ticket from the array list
                    tickets.remove(i);
                }
            }
        }
    }

    // create show_available method
    public void show_available() {
        // print index of available seats in each row
        System.out.print("Available seats in row 1: ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 'O') {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
        System.out.print("Available seats in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 'O') {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
        System.out.print("Available seats in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 'O') {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();

    }

    // create method save
    public void save() {
        // create a try catch block to handle exceptions
        try {
            // create a file object
            File file = new File("seats.txt");
            // create a file writer object
            FileWriter fileWriter = new FileWriter(file);
            // create a buffered writer object
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // write each row to file
            bufferedWriter.write(row1);
            bufferedWriter.newLine();
            bufferedWriter.write(row2);
            bufferedWriter.newLine();
            bufferedWriter.write(row3);
            bufferedWriter.newLine();
            // close buffered writer
            bufferedWriter.close();
            // display message
            System.out.println("File saved");
        } catch (IOException e) {
            // display error message
            System.out.println("Error writing to file");
        }
    }

    // create method load
    public void load() {
        // create a try catch block to handle exceptions
        try {
            // create a file object
            File file = new File("seats.txt");
            // create a file reader object
            FileReader fileReader = new FileReader(file);
            // create a buffered reader object
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // read each row from file
            row1 = bufferedReader.readLine().toCharArray();
            row2 = bufferedReader.readLine().toCharArray();
            row3 = bufferedReader.readLine().toCharArray();
            // close buffered reader
            bufferedReader.close();
            // display message
            System.out.println("File loaded");
        } catch (IOException e) {
            // display error message
            System.out.println("Error reading from file");
        }
    }

    // create method print_ticket_info
    public void print_ticket_info() {
        // create a variable to store total price
        double total_price = 0;
        // create a for loop to iterate through the array list
        for (int i = 0; i < tickets.size(); i++) {
            // print a border for ticket information
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

            // print ticket information
            tickets.get(i).print();
            // add ticket price to total price
            total_price += tickets.get(i).getPrice();

            // print a border for ticket information
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
        // print total price
        System.out.println("Total price: " + total_price + "£");
    }

    // create method sort_tickets that returns a new list of Tickets sorted by price
    // in ascending order (cheapest first)
    public ArrayList<Ticket> sort_tickets() {
        // sort the array list tickets based on price using linear sort
        for (int i = 0; i < tickets.size(); i++) {
            for (int j = i + 1; j < tickets.size(); j++) {
                if (tickets.get(i).getPrice() > tickets.get(j).getPrice()) {
                    Ticket temp = tickets.get(i);
                    tickets.set(i, tickets.get(j));
                    tickets.set(j, temp);
                }
            }
        }
        // return the sorted array list
        return tickets;
    }

    // create main methods
    public static void main(String[] args) {
        // create object of class theatre
        Theatre theatre = new Theatre();

        // display welcome message
        System.out.println("Welcome to the New Theatre");

        // create a while loop to keep the program running until user enters 0
        while (true) {
            // print menu
            System.out.println(
                    "-------------------------------------------------\n Please select an option:\n1) Buy a ticket\n2) Print seating area\n3) Cancel ticket\n4) List available seats\n5) Save to file\n6) Load from file\n7) Print ticket information and total price\n8) Sort tickets by price\n0) Quit\n------------------------------------------------- \n ");
            // create a scanner object
            Scanner input = new Scanner(System.in);
            // prompt user to enter a number
            System.out.print("Enter option: ");
            // store user input in variable
            int choice = input.nextInt();
            // create a switch statement to perform different actions based on user input
            switch (choice) {
                // if user enters 1 call method buy_ticket
                case 1:
                    theatre.buy_ticket();
                    break;
                // if user enters 2 call method print_seating_area
                case 2:
                    theatre.print_seating_area();
                    break;
                // if user enters 3 call method cancel_ticket
                case 3:
                    theatre.cancel_ticket();
                    break;
                // // if user enters 4 call method show_available
                case 4:
                    theatre.show_available();
                    break;
                // // if user enters 5 call method save
                case 5:
                    theatre.save();
                    break;
                // // if user enters 6 call method load
                case 6:
                    theatre.load();
                    break;
                // if user enters 7 call method print_ticket_info
                case 7:
                    theatre.print_ticket_info();
                    break;
                // if user enters 8 call method sort_tickets
                case 8:
                    // store th return value of method sort_tickets in a variable
                    ArrayList<Ticket> sorted_tickets = theatre.sort_tickets();
                    // display sorted tickets
                    // create a for loop to iterate through the array list
                    for (int i = 0; i < sorted_tickets.size(); i++) {
                        // print a border for ticket information
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                        // print ticket information
                        sorted_tickets.get(i).print();

                        // print a border for ticket information
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                    }
                    break;
                // if user enters 0 exit the program
                case 0:
                    System.exit(0);
                    break;
                // if user enters any other number display error message
                default:
                    System.out.println("Invalid input");
            }
        }

    }
}