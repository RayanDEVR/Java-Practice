package capstoneApp.service;

import capstoneApp.model.User;
import capstoneApp.model.Role;
import capstoneApp.exception.DuplicateException;
import capstoneApp.exception.NotFoundException;

public class UserService {
    private final UserRepository repository;
    private int nextId = 1;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(String username, String email, String password, Role role) {
        if (repository.usernameExists(username)) {
            throw new DuplicateException("Username alrady exists.");
        }

        if (repository.emailExists(email)) {
            throw new DuplicateException("Email already exists.");
        }

        User user = new User(nextId++, username, email, password, role);

        repository.save(user);

        return user;
    }

    public User findUser(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }
}
