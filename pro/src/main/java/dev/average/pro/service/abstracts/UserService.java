package dev.average.pro.service.abstracts;

import dev.average.pro.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User getUser(Long id);
    User newUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
