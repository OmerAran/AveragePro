package dev.average.pro.repository;

import dev.average.pro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);
    User findByUsername(String username);
    Integer countAllByUsername(String name);

}
