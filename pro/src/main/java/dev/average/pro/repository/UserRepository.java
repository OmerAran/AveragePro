package dev.average.pro.repository;

import dev.average.pro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);
    Optional<User> findByUsername(String username);
    Integer countAllByUsername(String name);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
