/*
Hospital Patient and Appointment Manager   [Mini Project | Project]
Model Patient, Doctor, Appointment and AppointmentStatus enum. Use interfaces if different consultation-fee 
policies are useful. Keep in-memory collections and validate appointments.
Done when: Prevent duplicate IDs and invalid status changes; list appointments by doctor/patient and 
summarize counts by status.
*/

import java.util.HashMap;
import java.util.Map;

enum AppointmentStatus {
    SCHEDULED, COMPLETED, CANCELLED
}

class Patient {
    String id;
    String name;
    
    Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Doctor {
    String id;
    String name;
    String speciality;
    
    Doctor(String id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
    }
}

class Appointment {
    String id;
    String patientId;
    String doctorId;
    String time;
    AppointmentStatus status;
    
    Appointment(String id, String patientId, String doctorId, String time) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.time = time;
        this.status = AppointmentStatus.SCHEDULED;
    }
}

class HospitalService {
    Map<String, Patient> patients = new HashMap<>();
    Map<String, Doctor> doctors = new HashMap<>();
    Map<String, Appointment> appointments = new HashMap<>();
    
    void addPatient(Patient patient) {                  //adding patient
        if (patients.containsKey(patient.id)) {
            System.out.println("Duplicate Patient ID. Name: " + patient.name);
            return;
        }
        
        patients.put(patient.id, patient);
    }
    
    void addDoctor(Doctor doctor) {                     //adding doctor
        if (doctors.containsKey(doctor.id)) {
            System.out.println("Duplicate Doctor ID. Name: " + doctor.name);
            return;
        }
        
        doctors.put(doctor.id, doctor);
    }
    
    void createAppointment(Appointment appointment) {       //creating appointment
        if (appointments.containsKey(appointment.id)) {
            System.out.println("Duplicate Appointment ID.");
            return;
        }
        
        if (!patients.containsKey(appointment.patientId)) {
            System.out.println("Patient not found.");
            return;
        }
        
        if (!doctors.containsKey(appointment.doctorId)) {
            System.out.println("Doctor not found.");
            return;
        }
        
        appointments.put(appointment.id, appointment);
    }
    
    void changeStatus(String appointmentId, AppointmentStatus status) {     //changing appointment status
        Appointment appointment = appointments.get(appointmentId);
        
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }
        
        if (appointment.status != AppointmentStatus.SCHEDULED) {
            System.out.println("Invalid status change.");
            return;
        }
        
        appointment.status = status;
    }
    
    void listByDoctor(String doctorId) {            
        System.out.println("\nAppointments of Doctor " + doctorId);
        
        for (Appointment a: appointments.values()) {
            if (a.doctorId.equals(doctorId)) {
                System.out.println(a.id + " | Patient " + a.patientId + " | Time: " + a.time + " | " + a.status);
            }
        }
    }
    
    void listByPatient(String patientId) {
        System.out.println("\nAppointments of Patient " + patientId);
        
        for (Appointment a: appointments.values()) {
            if (a.patientId.equals(patientId)) {
                System.out.println(a.id + " | Doctor " + a.doctorId + " | Time: " + a.time + " | " + a.status);
            }
        }
    }
    
    void statusSummary() {
        int scheduled = 0;
        int completed = 0;
        int cancelled = 0;
        
        for (Appointment a: appointments.values()) {
            if (a.status == AppointmentStatus.SCHEDULED) {
                scheduled++;
            }
            
            if (a.status == AppointmentStatus.COMPLETED) {
                completed++;
            }
            
            if (a.status == AppointmentStatus.CANCELLED) {
                cancelled++;
            }
        }
        
        System.out.println("\nStatus Summary: ");
        System.out.println("Scheduled: " + scheduled);
        System.out.println("Completed: " + completed);
        System.out.println("Cancelled: " + cancelled);
    }
}

public class Ex186HospitalPatientAndAppointmentManager {
    public static void main(String[] args) {
        HospitalService hospital = new HospitalService();
    
    hospital.addPatient(new Patient("P-101", "Rayan"));
    hospital.addPatient(new Patient("P-102", "Samiul"));
        hospital.addPatient(new Patient("P-101", "Radoan"));
    
    hospital.addDoctor(new Doctor("D-101", "Khan", "Cardiology"));
    hospital.addDoctor(new Doctor("D-102", "Rahman", "Dermatology"));
        hospital.addDoctor(new Doctor("D-101", "Karim", "Brain Surgeon"));
    
    hospital.createAppointment(new Appointment("A-101", "P-101", "D-101", "10:00 AM"));
    hospital.createAppointment(new Appointment("A-102", "P-102", "D-102", "12:00 PM"));
    hospital.createAppointment(new Appointment("A-103", "P-102", "D-101", "11:00 PM"));
    
    hospital.changeStatus("A-102", AppointmentStatus.COMPLETED);
    
    hospital.listByDoctor("D-101");
    hospital.listByPatient("P-102");
    
    hospital.statusSummary();
    }
}