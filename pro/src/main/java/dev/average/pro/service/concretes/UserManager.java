package dev.average.pro.service.concretes;

import dev.average.pro.model.User;
import dev.average.pro.repository.UserRepository;
import dev.average.pro.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class UserManager implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {

        return userRepository.getById(id);
    }

    @Override
    public User newUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User newUser) {
        Optional<User> oldUser = userRepository.findById(id);
        if (oldUser.isPresent()){
            oldUser.get().setUsername(newUser.getUsername());
            oldUser.get().setEmail(newUser.getEmail());
             userRepository.save(oldUser.get());
            return oldUser.get();
        }
        else {
            return null;
        }

    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());

            userRepository.deleteById(id);

    }
}
