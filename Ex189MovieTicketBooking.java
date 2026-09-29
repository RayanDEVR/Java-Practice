/*
Movie Ticket Booking [Mini Project | Project]
Use a 2D seat array or object array for one show, Movie/Show/Booking models and BookingStatus enum. 
Validate seat coordinates and prevent double booking.
Done when: Support view seats, book selected seats, cancel booking, calculate price and print booking 
summary with unique booking ID.
*/

import java.util.Map;
import java.util.HashMap;

enum BookingStatus {
    Booked, Cancelled
}

class Movie {
    String title;
    double ticketPrice;
    
    Movie(String title, double ticketPrice) {
        this.title = title;
        this.ticketPrice = ticketPrice;
    }
}

class Show {
    Movie movie;
    boolean[][] seats;
    
    Show(Movie movie, int rows, int columns) {
        this.movie = movie;
        seats = new boolean[rows][columns];
    }
    
    void viewSeats() {
        System.out.println("\nSeats Status:");
        
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if(seats[i][j]) 
                    System.out.print("[X] ");
                else
                    System.out.print("[O] ");
            }
            System.out.println();
        }
    }
}

class Booking {
    String id;
    int row;
    int column;
    double ticketPrice;
    BookingStatus status;
    
    Booking(String id, int row, int column, double ticketPrice) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.ticketPrice = ticketPrice;
        this.status = BookingStatus.Booked;
    }
}

class BookingService {
    Map<String, Booking> bookings = new HashMap<>();
    
    void bookSeat(Show show, String bookingId, int row, int column) {
        if (row < 0 || row >= show.seats.length || column < 0 || column >= show.seats[row].length) {
            System.out.println(bookingId + ", invalid seat.");
            return;
        }
        
        if (show.seats[row][column]) {
            System.out.println("Seat(Row " + row + " Column " + column + ") already booked.");
            return;
        }
        
        if (bookings.containsKey(bookingId)) {
            System.out.println("Booking ID already exists.");
        }
        
        show.seats[row][column] = true;
        
        Booking booking = new Booking(bookingId, row, column, show.movie.ticketPrice);
        
        bookings.put(bookingId, booking);
        
        System.out.println(bookingId + ", seat booked successfully.");
        }
    
    void cancelBooking(Show show, String bookingId) {
        Booking booking = bookings.get(bookingId);
        
        if (bookings == null) {
            System.out.println("Booking ID not found.");
            return;
        }
        
        show.seats[booking.row][booking.column] = false;
        booking.status = BookingStatus.Cancelled;
        
        System.out.println("\n" + bookingId + ", booking cancelled.");
    }
    
    void bookingSummary(String bookingId) {
        Booking booking = bookings.get(bookingId);
        
        if (booking == null) {
            System.out.println("Booking ID not found.");
            return;
        }
        
        System.out.println("\nBooking Summary for " + bookingId + ": ");
        System.out.println("ID: " + booking.id);
        System.out.println("Seat: Row " + booking.row + ", Column " + booking.column);
        System.out.println("Price: " + booking.ticketPrice);
        System.out.println("Status: " + booking.status);
    }
}

public class Ex189MovieTicketBooking {
    public static void main(String[] args) {
        Movie movie = new Movie("Avengers", 300);
        Show show = new Show(movie, 3, 4);
        BookingService service = new BookingService();
        
        show.viewSeats();
        
        System.out.println();
        
        service.bookSeat(show, "B-101", 1, 2);
        service.bookSeat(show, "B-102", 2, 3);
        service.bookSeat(show, "B-103", 4, 7);
        
        show.viewSeats();
        
        service.bookingSummary("B-101");
        service.cancelBooking(show, "B-102");
        
        show.viewSeats();
    }
}