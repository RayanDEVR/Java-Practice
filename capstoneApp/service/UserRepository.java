package capstoneApp.service;

import capstoneApp.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UserRepository {
    private final Map<Integer, User> users = new HashMap<>();
    private final Set<String> usernames = new HashSet<>();
    private final Set<String> emails = new HashSet<>();

    public void save(User user) {
        users.put(user.getId(), user);
        usernames.add(user.getUsername().toLowerCase());
        emails.add(user.getEmail().toLowerCase());
    }

    public boolean usernameExists(String username) {
        return usernames.contains(username.toLowerCase());
    }

    public boolean emailExists(String email) {
        return emails.contains(email.toLowerCase());
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
