/*
Parking Lot Manager [Mini Project | Project]
Model Vehicle, ParkingTicket, Slot and VehicleType enum. Use arrays/collections for slots and Map for active 
ticket lookup. Calculate fee from prepared duration values.
Done when: No slot is assigned twice; exit frees it; invalid/missing ticket is handled; occupancy and revenue 
reports are available.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

enum VehicleType {
    Car, Bike, Bus
}

class Vehicle {
    String number;
    VehicleType type;
    
    Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }
}

class Slot {
    int id;
    boolean occupied;
    Vehicle vehicle;
    
    Slot(int id) {
        this.id = id;
        this.occupied = false;
    }
}

class ParkingTicket {
    String ticketId;
    Vehicle vehicle;
    int slotId;
    double fee;
    
    ParkingTicket(String ticketId, Vehicle vehicle, int slotId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slotId = slotId;
    }
}

class ParkingLot {
    List<Slot> slots = new ArrayList<>();
    Map<String, ParkingTicket> activeTickets = new HashMap<>();
    
    double revenue = 0;
    
    ParkingLot(int numberOfSlots) {
        for (int i = 1; i <= numberOfSlots; i++) {
            slots.add(new Slot(i));
        }
    }
    
    void parkVehicle(Vehicle vehicle, String ticketId) {
        for (Slot slot : slots) {
            if(!slot.occupied) {
                slot.occupied = true;
                slot.vehicle = vehicle;
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, slot.id);
                activeTickets.put(ticketId, ticket);
                System.out.println(vehicle.number + " parked at Slot " + slot.id);
                return;
            }
        }
        
        System.out.println("No empty slot.");
    }
    
    void exitVehicle(String ticketId, int durationHours) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        
        if(ticket == null) {
            System.out.println("Invalid ticket.");
            return;
        }
        
        ticket.fee = durationHours * 50;
        revenue += ticket.fee;
        
        for (Slot slot: slots) {
            if (slot.id == ticket.slotId) {
                slot.occupied = false;
                slot.vehicle = null;
                break;
            }
        }
        
        activeTickets.remove(ticketId);
        System.out.println("Vehicle " + ticket.vehicle.number + " exited. Fee " + ticket.fee);
    }
    
    void occupancyReport() {
        int occupied = 0;
        
        for (Slot slot: slots) {
            if(slot.occupied) {
                occupied++;
            }
        }
        System.out.println("\nOccupied: " + occupied + "/" + slots.size());
        System.out.println("Revenue: " + revenue);
    }
}

public class Ex190ParkingLotManager {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3);
        Vehicle v1 = new Vehicle("DHAKA-101", VehicleType.Bike);
        Vehicle v2 = new Vehicle("DHAKA-102", VehicleType.Car);
        
        lot.parkVehicle(v1, "T001");
        lot.parkVehicle(v2, "T002");
        
        lot.occupancyReport();
        
        lot.exitVehicle("T001", 5);
        
        lot.occupancyReport();
    }
}