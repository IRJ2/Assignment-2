import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// define class Theatre
public class Theatre {
    // Initialize seat arrays for each row of the theatre
    char[] row1Seats = new char[12]; // 12 seats in row 1
    char[] row2Seats = new char[16]; // 16 seats in row 2
    char[] row3Seats = new char[20]; // 20 seats in row 3
    // Create an ArrayList to store all purchased purchasedTickets
    ArrayList<Ticket> purchasedTickets = new ArrayList<Ticket>();

    // Set all seats to "unoccupied" at the start
    public Theatre() {
        // Loop through each seat in each row 1 and set it to "unoccupied"
        for (int i = 0; i < row1Seats.length; i++) {
            row1Seats[i] = 'O';
        }
        // Loop through each seat in each row 2 and set it to "unoccupied"
        for (int i = 0; i < row2Seats.length; i++) {
            row2Seats[i] = 'O';
        }
        // Loop through each seat in each row 3 and set it to "unoccupied"
        for (int i = 0; i < row3Seats.length; i++) {
            row3Seats[i] = 'O';
        }
    }

    // Function to buy a ticket
    public void buy_ticket() {
        // Creating a scanner object to get input
        Scanner scanner = new Scanner(System.in);

        // Asking for user's personal information
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter your surname: ");
        String surname = scanner.nextLine();

        System.out.print("Please enter your email: ");
        String email = scanner.nextLine();

        // Creating a new Person object with the information given
        Person person = new Person(name, surname, email);

        // Asking for row and seat number
        System.out.print("Please enter the row number: ");
        int rowNumber = scanner.nextInt();

        System.out.print("Please enter the seat number: ");
        int seatNumber = scanner.nextInt();

        // Creating a flag to check if the seat is available
        boolean isAvailable = false;
        // Checking the row number entered by the user
        switch (rowNumber) {
            // If user enters 1
            case 1:
                // checking if the seat number entered by the user is valid
                if (seatNumber > 12 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                } else {
                    if (row1Seats[seatNumber - 1] == 'O') {// Checking if the seat is available
                        System.out.println("Ticket purchased");
                        row1Seats[seatNumber - 1] = 'X'; // Marking the seat as booked
                        isAvailable = true;
                    } else {
                        System.out.println("Seat is not available");
                    }
                }
                break;

            // If user enters 2
            case 2:
                // checking if the seat number entered by the user is valid
                if (seatNumber > 16 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                } else {
                    if (row2Seats[seatNumber - 1] == 'O') {// Checking if the seat is available
                        System.out.println("Ticket purchased");
                        row2Seats[seatNumber - 1] = 'X'; // Marking the seat as booked
                        isAvailable = true;
                    } else {
                        System.out.println("Seat is not available");
                    }
                }
                break;

            // If user enters 3
            case 3:
                // checking if the seat number entered by the user is valid
                if (seatNumber > 20 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                } else {
                    if (row3Seats[seatNumber - 1] == 'O') {// Checking if the seat is available
                        System.out.println("Ticket purchased");
                        row3Seats[seatNumber - 1] = 'X'; // Marking the seat as booked
                        isAvailable = true;
                    } else {
                        System.out.println("Seat is not available");
                    }
                }

                break;

            // If user enters anything else
            default:
                System.out.println("Invalid row number");
                break;

        }
        // If the seat is available, adding a ticket to the purchasedTickets ArrayList
        if (isAvailable) {
            int ticketPrice = 0;

            // Checking the row number entered by the user to get the price of the ticket
            // using if-else
            if (rowNumber == 1) {
                ticketPrice = 100;
            } else if (rowNumber == 2) {
                ticketPrice = 75;
            } else if (rowNumber == 3) {
                ticketPrice = 50;
            }

            // Creating a new Ticket object with the information given
            Ticket ticket = new Ticket(rowNumber, seatNumber, ticketPrice, person);
            // Adding the ticket to the purchasedTickets ArrayList
            purchasedTickets.add(ticket);
        }
    }

    // Function to print the seating area
    public void print_seating_area() {
        // print each row in a pyramid pattern
        // print pattern for the stage
        System.out.print("    ***********\n     * STAGE *\n    ***********\n");
        // set the initial number of spaces to 4
        int spaces = 4;

        // loop through each row
        for (int row = 0; row < 3; row++) {
            // print the spaces for the current row
            for (int spaceCount = 0; spaceCount < spaces; spaceCount++) {
                System.out.print(" ");
            }

            // decrement the number of spaces by 2 for the next row
            spaces -= 2;

            // print the first half of the seats for the current row
            if (row == 0) {
                for (int seat = 0; seat < row1Seats.length / 2; seat++) {
                    System.out.print(row1Seats[seat]);
                }

                // add a space between the two halves of the seats
                System.out.print(" ");

                // print the second half of the seats for the current row
                for (int seat = row1Seats.length / 2; seat < row1Seats.length; seat++) {
                    System.out.print(row1Seats[seat]);
                }
            }

            // repeat the process for the second and third rows
            if (row == 1) {
                for (int seat = 0; seat < row2Seats.length / 2; seat++) {
                    System.out.print(row2Seats[seat]);
                }

                System.out.print(" ");

                for (int seat = row2Seats.length / 2; seat < row2Seats.length; seat++) {
                    System.out.print(row2Seats[seat]);
                }
            }

            if (row == 2) {
                for (int seat = 0; seat < row3Seats.length / 2; seat++) {
                    System.out.print(row3Seats[seat]);
                }

                System.out.print(" ");

                for (int seat = row3Seats.length / 2; seat < row3Seats.length; seat++) {
                    System.out.print(row3Seats[seat]);
                }
            }

            // print a new line at the end of each row
            System.out.println();
        }
    }

    // Function to cancel a ticket
    public void cancel_ticket() {
        // Initializing Scanner Object
        Scanner userInput = new Scanner(System.in);
        // Prompting user to enter row number
        System.out.print("Enter the Row Number: ");
        int rowNumber = userInput.nextInt();

        // Prompting user to enter seat number
        System.out.print("Enter the Seat Number: ");
        int seatNumber = userInput.nextInt();

        // Initializing flag variable to determine if ticket is cancelled or not
        boolean isTicketCancelled = false;

        // Creating a switch statement to cancel the ticket in the row entered by the
        // user
        switch (rowNumber) {
            // if user enters 1
            case 1:
                // checking seat number is valid or not
                if (seatNumber > 10 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                } else {
                    // display message
                    System.out.println("Ticket cancelled");
                    // set seat to O
                    row1Seats[seatNumber - 1] = 'O';
                    isTicketCancelled = true; // ticket is cancelled
                }
                break;
            // if user enters 2
            case 2:
                // checking seat number is valid or not
                if (seatNumber > 15 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                } else {
                    // display message
                    System.out.println("Ticket cancelled");
                    // set seat to O
                    row2Seats[seatNumber - 1] = 'O';
                    isTicketCancelled = true; // ticket is cancelled
                }
                break;
            // if user enters 3
            case 3:
                // checking seat number is valid or not
                if (seatNumber > 20 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                } else {
                    // display message
                    System.out.println("Ticket cancelled");
                    // set seat to O
                    row3Seats[seatNumber - 1] = 'O';
                    isTicketCancelled = true; // ticket is cancelled
                }
                break;
            // if user enters any other number display error message
            default:
                System.out.println("Invalid row number");
        }

        // if ticket is cancelled
        if (isTicketCancelled) {
            // Iterating through the ArrayList
            for (int i = 0; i < purchasedTickets.size(); i++) {
                // if row and seat number matches
                if (purchasedTickets.get(i).getRowNumber() == rowNumber
                        && purchasedTickets.get(i).getSeatNumber() == seatNumber) {
                    // remove ticket from the array list
                    purchasedTickets.remove(i);
                }
            }
        }
    }

    // Function to print the purchased tickets
    public void show_available() {
        // Prints the seat number(index) of available seats for each row
        for (int row = 1; row <= 3; row++) {// loop through each row
            System.out.print("Available seats in row " + row + ": ");
            char[] currentRow = null;// create a char array to store the current row
            if (row == 1) {// if row is 1
                currentRow = row1Seats; // set current row to row1Seats
            } else if (row == 2) {// if row is 2
                currentRow = row2Seats; // set current row to row2Seats
            } else {// if row is 3
                currentRow = row3Seats; // set current row to row3Seats
            }
            // loop through each seat in the current row
            for (int seatIndex = 0; seatIndex < currentRow.length; seatIndex++) {
                if (currentRow[seatIndex] == 'O') { // if seat is available
                    System.out.print(seatIndex + 1 + " ");// print seat number
                }
            }
            System.out.println();
        }

    }

    // Function to save the seats to a file
    public void save() {
        // add try catch block to handle exceptions
        try {
            // create file object
            File file = new File("seats.txt");
            // create file writer object
            FileWriter fw = new FileWriter(file);
            // create buffered writer object
            BufferedWriter bw = new BufferedWriter(fw);
            // write each row to file
            bw.write(row1Seats);
            bw.newLine();
            bw.write(row2Seats);
            bw.newLine();
            bw.write(row3Seats);
            bw.newLine();
            // close buffered writer
            bw.close();
            // print message
            System.out.println("File saved successfully");
        } catch (IOException ex) {
            // print error message
            System.out.println("Error occurred while saving file");
        }
    }

    // Function to load the seats from a file
    public void load() {
        // create a try catch block to handle exceptions
        try {
            // create a file object and read it using a bufferedReader
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("seats.txt")));
            // read each row from file
            row1Seats = bufferedReader.readLine().toCharArray();
            row2Seats = bufferedReader.readLine().toCharArray();
            row3Seats = bufferedReader.readLine().toCharArray();
            // close buffered reader
            bufferedReader.close();
            // display message
            System.out.println("File loaded");
        } catch (IOException e) {
            // display error message
            System.out.println("Error reading from file");
        }
    }

    // Function to print the ticket information
    public void print_ticket_info() {
        // initialize variable for total price
        double totalPrice = 0;

        // loop through purchased tickets and print ticket information
        for (int i = 0; i < purchasedTickets.size(); i++) {
            System.out.println("----------------------------");
            purchasedTickets.get(i).print();
            totalPrice += purchasedTickets.get(i).getTicketPrice();
        }

        // print total price
        System.out.println("Total Price: " + totalPrice + " GBP");
    }

    // Function to sort purchased Tickets based on price in ascending order(cheapest
    // first)
    public ArrayList<Ticket> sort_purchasedTickets() {
        // Sort the purchasedTickets list by price using selection sort
        for (int i = 0; i < purchasedTickets.size() - 1; i++) {
            // Assume that the current element at index i is the minimum value
            int minIndex = i;
            // Iterate through the remaining elements of the list to find the smallest
            // element
            for (int j = i + 1; j < purchasedTickets.size(); j++) {
                // If the current element is smaller than the assumed minimum value, update the
                // index of the minimum value
                if (purchasedTickets.get(j).getTicketPrice() < purchasedTickets.get(minIndex).getTicketPrice()) {
                    minIndex = j;
                }
            }
            // If the minimum value is not already at index i, swap the elements at i and
            // minIndex
            if (minIndex != i) {
                Ticket temp = purchasedTickets.get(i);
                purchasedTickets.set(i, purchasedTickets.get(minIndex));
                purchasedTickets.set(minIndex, temp);
            }
        }
        // Return the sorted list
        return purchasedTickets;
    }

    // main method
    public static void main(String[] args) {

        Theatre theatre = new Theatre();// create a theatre object

        // print welcome message
        System.out.println("Welcome to the New Theatre");

        // creating a while loop to keep the program running until user enters 0
        while (true) {
            // display menu
            System.out.println(
                    "-------------------------------------------------\n Please select an option:\n1) Buy a ticket\n2) Print seating area\n3) Cancel ticket\n4) List available seats\n5) Save to file\n6) Load from file\n7) Print ticket information and total price\n8) Sort purchasedTickets by price\n0) Quit\n------------------------------------------------- \n ");
            // Creating a scanner object to get input
            Scanner input = new Scanner(System.in);
            // asking user to enter a number
            System.out.print("Enter option: ");
            // storing user input in variable
            int choice = input.nextInt();
            // switch case to call the appropriate method based on user input
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
                // if user enters 4 call method show_available
                case 4:
                    theatre.show_available();
                    break;
                // if user enters 5 call method save
                case 5:
                    theatre.save();
                    break;
                // if user enters 6 call method load
                case 6:
                    theatre.load();
                    break;
                // if user enters 7 call method print_ticket_info
                case 7:
                    theatre.print_ticket_info();
                    break;
                // if user enters 8 call method sort_purchasedTickets
                case 8:
                    // store the sorted list in a variable
                    ArrayList<Ticket> sorted_purchasedTickets = theatre.sort_purchasedTickets();
                    // loop through the sorted list and print ticket information
                    for (int i = 0; i < sorted_purchasedTickets.size(); i++) {
                        System.out.println("-----------------------------");
                        // print ticket information
                        sorted_purchasedTickets.get(i).print();
                        System.out.println("-----------------------------");
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