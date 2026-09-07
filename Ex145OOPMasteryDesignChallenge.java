/*
OOP Mastery Design Challenge   [Build from Scratch | Advanced]
Design a small vehicle-rental domain: Vehicle abstraction, Car/Bike implementations, Rentable contract if useful, 
Customer, Rental and RentalStatus enum. Implement price calculation and state transitions.
Done when: A short design rationale explains every inheritance/interface decision and invalid rentals are 
prevented.
*/

enum RentalStatus {
    ACTIVE, COMPLETE, CANCELLED
}

abstract class Vehicle {
    protected String model;
    protected double rentPerDay;

    Vehicle(String model, double rentPerDay) {
        this.model = model;
        this.rentPerDay = rentPerDay;
    }

    abstract double calculateRent(int days);
}

class Car extends Vehicle {
    Car(String model, double rentPerDay) {
        super(model, rentPerDay);
    }

    @Override 
    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Bike extends Vehicle {
    Bike(String model, double rentPerDay) {
        super(model, rentPerDay);
    }

    @Override 
    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private RentalStatus status;

    Rental(Vehicle vehicle, Customer customer, RentalStatus rentalStatus) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.status = rentalStatus;
    }

    void rent(int days) {
        status = RentalStatus.ACTIVE;

        System.out.println("Customer name: " + customer.getName());
        System.out.println("Current rent status: " + status);
        System.out.println("Total rent: " + vehicle.calculateRent(days));
    }
}

public class Ex145OOPMasteryDesignChallenge {
    public static void main(String[] args) {
        Vehicle vehicle = new Car("Toyota", 3000);
        Customer customer = new Customer("Rayan");
        Rental rental = new Rental(vehicle, customer, RentalStatus.ACTIVE);

        rental.rent(3);
    }
}
