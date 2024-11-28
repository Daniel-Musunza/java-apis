package com.example.crudapi.repository;

import com.example.crudapi.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1L, "Alice", "alice@example.com"));
        users.add(new User(2L, "Bob", "bob@example.com"));
        users.add(new User(3L, "Charlie", "charlie@example.com"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
