package dev.nano.springsecurityjwt0auth.service;

import dev.nano.springsecurityjwt0auth.entity.User;

import java.util.List;

public interface UserService {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User register(String firstName, String lastName, String username, String email);

    List<User> getUsers();

}