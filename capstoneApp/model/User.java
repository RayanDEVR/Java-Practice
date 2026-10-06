package capstoneApp.model;

import java.util.Objects;

public class User {
    private final int id;
    private final String username;
    private final String email;
    private final String password;
    private final Role role;

    public User(int id, String username, String email, String password, Role role) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid User ID.");
        }

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty..");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }

        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("Password must contain at least 4 characters..");
        }

        if (role == null) {
            throw new IllegalArgumentException("Role cannot be empty.");
        }

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " | " + username + " | " + email  + " | " + role;
    }
}
