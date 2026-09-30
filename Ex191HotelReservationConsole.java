/*
Hotel Reservation Console [Mini Project | Project]
Model Room, Guest, Reservation and ReservationStatus. Use Map for room lookup, List for reservations, 
interface/strategy for price calculation if room types differ.
Done when: Prevent overlapping active reservation in the simplified date-free model by using an explicit 
occupied flag/status; support reserve, check-in, check-out, cancel and reports
*/


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

enum ReservationStatus {
    Reserved, Checked_In, Checked_Out, Cancelled
}

class Room {
    int number;
    String type;
    double price;
    boolean occupied;
    
    Room(int number, String type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.occupied = false;
    }
}

class Guest {
    int id;
    String name;
    
    Guest(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Reservation {
    int id;
    Guest guest;
    Room room;
    ReservationStatus status;
    
    Reservation(int id, Guest guest, Room room) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.status = ReservationStatus.Reserved;
    }
}

class HotelService {
    Map<Integer, Room> rooms = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();
    
    void addRoom(Room room) {
        rooms.put(room.number, room);
    }
    
    void reserveRoom(int reservationId, Guest guest, int roomNumber) {
        Room room = rooms.get(roomNumber);
        
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }
        
        if (room.occupied) {
            System.out.println("Room is already occupied.");
            return;
        }
        
        room.occupied = true;
        
        Reservation reservation = new Reservation(reservationId, guest, room);
        
        reservations.add(reservation);
        
        System.out.println("Room " + roomNumber + " reserved successfully.");
    }
    
    Reservation findReservation(int id) {
        for (Reservation r: reservations) {
            if (r.id == id) {
                return r;
            }
        }
        return null;
    }
    
    void checkIn(int reservationId) {
        Reservation reservation = findReservation(reservationId);
        
        if (reservation == null) {
            System.out.println("Reservation not found.");
            return;
        }
        
        if (reservation.status != ReservationStatus.Reserved) {
            System.out.println("Invalid reservation.");
            return;
        }
        
        reservation.status = ReservationStatus.Checked_In;
        
        System.out.println("Guest checked-in.");
    }
    
    void checkOut(int reservationId) {
        Reservation reservation = findReservation(reservationId);
        
        if(reservation == null) {
            System.out.println("Reservation not fond.");
            return;
        }
        
        if (reservation.status != ReservationStatus.Checked_In) {
            System.out.println("Invalid checked-in.");
            return;
        }
        
        reservation.status = ReservationStatus.Checked_Out;
        reservation.room.occupied = false;
        
        System.out.println("Guest checked-out.");
    }
    
    void cancel(int reservationId) {
        Reservation reservation = findReservation(reservationId);
        
        if (reservation == null) {
            System.out.println("Reservation not found.");
            return;
        }
        
        if (reservation.status != ReservationStatus.Reserved) {
            System.out.println("Cannot cancel now");
            return;
        }
        
        reservation.status = ReservationStatus.Cancelled;
        reservation.room.occupied = false;
        
        System.out.println("Reservation cancelled.");
    }
    
    void report() {
        System.out.println("\n--- Hotel Report ---");
        
        for (Reservation r : reservations) {
            System.out.println("Reservation: " + r.id + " | Guest: " + r.guest.name + " | Room: " + r.room.number + " | Status:  " + r.status);
        }
    }
}

public class Ex191HotelReservationConsole {
    public static void main(String[] args) {
        HotelService hotel = new HotelService();
        
        hotel.addRoom(new Room(101, "Single", 2000));
        hotel.addRoom(new Room(102, "Double", 3000));
        
        Guest guest = new Guest(1, "Rayan");
        
        hotel.reserveRoom(1001, guest, 101);
        hotel.report();
        System.out.println();
        
        hotel.checkIn(1001);
        hotel.report();
        System.out.println();
        
        hotel.checkOut(1001);
        hotel.report();
        
    }
}