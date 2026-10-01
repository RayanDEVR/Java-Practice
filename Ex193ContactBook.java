/*
Contact Book [Mini Project | Project]
Model Contact with stable ID, name, phone and email. Use Map by ID and Set to reject duplicate phone/email 
according to chosen rules. Support add, update, remove, search and sorted list.
Done when: Updates preserve uniqueness, missing IDs are handled, and toString hides no required field while 
remaining readable.
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Contact {
    String id;
    String name;
    String phone;
    String email;
    
    Contact(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}

class ContactBook {
    Map<String, Contact> contacts = new HashMap<>();
    List<String> phones = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    
    void addContact(Contact contact) {
        if (contacts.containsKey(contact.id)) {
            System.out.println("Duplicate ID: " + contact.id + " found.");
            return;
        }
        
        if (phones.contains(contact.phone)) {
            System.out.println("Duplicate Number: " + contact.phone + " found for ID: " + contact.id);
            return;
        }
        
        if (emails.contains(contact.email)) {
            System.out.println("Duplicate Email: " + contact.email + " found for ID : " + contact.id);
            return;
        }
        
        contacts.put(contact.id, contact);
        phones.add(contact.phone);
        emails.add(contact.email);
    }
    
    void updateContact(String id, String name, String phone, String email) {
        Contact contact = contacts.get(id);
        
        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }
        
        if (!contact.phone.equals(phone) && phones.contains(phone)) {
            System.out.println("Phone already exists.");
            return;
        }
        
        if (!contact.email.equals(email) && emails.contains(email)) {
            System.out.println("Email already exists.");
            return;
        }
        
        phones.remove(contact.phone);
        emails.remove(contact.email);
        
        contact.name = name;
        contact.phone = phone;
        contact.email = email;
        
        phones.add(phone);
        emails.add(email);
    }
    
    void removeContact(String id) {
        Contact contact = contacts.remove(id);
        
        if (contact == null) {
            System.out.println("\nContact not found.");
            return;
        }
        
        phones.remove(contact.phone);
        emails.remove(contact.email);
        
        System.out.println("\nContact ID " + id + " removed.");
    }
    
    void searchContact(String id) {
        Contact contact = contacts.get(id);
        
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }
        
        System.out.println("\n" + contact);
    }
    
    void showSortedContact() {
        System.out.println("\nContacts: ");
        
        contacts.values()
                .stream()
                .sorted(Comparator.comparing(c -> c.name))
                .forEach(System.out::println);
    }
}

public class Ex193ContactBook {
    public static void main(String[] args) {
     ContactBook book = new ContactBook();
        
        book.addContact(new Contact("C-101", "Rayan", "01963425958", "rayan@gmail.com"));
        book.addContact(new Contact("C-102", "Samiul", "01258432784", "samiul@gmail.com"));
        book.addContact(new Contact("C-103", "Radoan", "01785463215", "radoan@gmail.com"));
        book.addContact(new Contact("C-102", "Abdullah", "01856497325", "abdullah@gmail.com"));
        book.showSortedContact();
        
        book.updateContact("C-103", "Azam", "01987656568", "new@gmail.com");
        book.updateContact("C-102", "Khan", "01785463215", "new23@gmail.com");
        book.showSortedContact();
        
        book.removeContact("C-101");
        
        book.searchContact("C-103");
        
        book.showSortedContact();
    }
}