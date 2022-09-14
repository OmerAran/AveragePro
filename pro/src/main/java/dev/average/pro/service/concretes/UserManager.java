package dev.average.pro.service.concretes;

import dev.average.pro.exception.ResourceNotFoundException;
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

        return userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("not found user with id : "+id));
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findAllByUsername(name);
    }

    @Override
    public User newUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User newUser) {
        User oldUser = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not Found User with id: "+id));

        oldUser.setUsername(newUser.getUsername());
        oldUser.setEmail(newUser.getEmail());

        userRepository.save(oldUser);
        return oldUser;
    }

    @Override
    public Integer countAllByUsername(String name) {
        int countUsersByName = userRepository.countAllByUsername(name);
        return countUsersByName;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Not found user with id :"+id));

        userRepository.deleteById(id);

    }
}
