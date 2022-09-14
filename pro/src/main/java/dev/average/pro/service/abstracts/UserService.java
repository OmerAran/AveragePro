package dev.average.pro.service.abstracts;

import dev.average.pro.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User getUser(Long id);
   List<User> getUsersByName(String name);
    User newUser(User user);

    User updateUser(Long id, User user);

    Integer countAllByUsername(String name);
    void deleteUser(Long id);
}
