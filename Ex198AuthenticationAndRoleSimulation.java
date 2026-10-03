/*
Authentication and Role Simulation [Mini Project | Project]
Model User, Role enum and AuthService with Map lookup. Support registration, login attempt handling, 
active/locked status and role-based action checks using conditions/interfaces where appropriate.
Done when: Duplicate username is rejected, password comparison uses String content, lockout rule works and 
unauthorized actions fail with a clear domain exception/message.
*/


import java.util.HashMap;
import java.util.Map;

enum Role {
    Admin, User
}

class User {
    private String username;
    private String password;
    private Role role;
    
    boolean active = true;
    boolean locked = false;
    int wrongAttempts = 0;
    
    User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    String getUsername() {
        return username;
    }
    
    String getPassword() {
        return password;
    }
    
    Role getRole() {
        return role;
    }
}

class AuthService {
    Map<String, User> users = new HashMap<>();
    
    void register(String username, String password, Role role) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        
        User user = new User(username, password, role);
        users.put(username, user);
        
        System.out.println("Registration successful.");
    }
    
    User login(String username, String password) {
        User user = users.get(username);
        
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }
        
        if (user.locked) {
            System.out.println("Account is locked.");
            return null;
        }
        
        if (user.getPassword().equals(password)) {
            user.wrongAttempts = 0;
            System.out.println("Login successful.");
            return user;
        }
        
        user.wrongAttempts++;
        System.out.println("Wrong password.");
        
        if (user.wrongAttempts >= 3) {
            user.locked = true;
            System.out.println("Account locked.");
        }
        
        return null;
    }
    
    void checkAdmin(User user) {
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }
        
        if (user.getRole() == Role.Admin) {
            System.out.println("Admin action allowed.");
        }
        else
            System.out.println("Unauthorized action.");
    }
}

public class Ex198AuthenticationAndRoleSimulation {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        
        auth.register("Rayan", "1111", Role.Admin);
        auth.register("Samiul", "2222", Role.User);
        
        System.out.println();
        
        auth.login("Rayan", "2222");
        auth.login("Rayan", "3333");
        auth.login("Rayan", "4444");
        
        System.out.println();
        
        auth.login("Rayan", "1111");
        auth.login("Samiul", "2222");
        
        System.out.println();
        
        User user = auth.login("Rayan", "1111");
        auth.checkAdmin(user);
    }
}