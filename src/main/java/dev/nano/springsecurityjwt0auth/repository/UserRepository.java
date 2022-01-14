package dev.nano.springsecurityjwt0auth.repository;

import dev.nano.springsecurityjwt0auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
