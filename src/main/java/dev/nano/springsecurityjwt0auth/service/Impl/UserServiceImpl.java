package dev.nano.springsecurityjwt0auth.service.Impl;

import dev.nano.springsecurityjwt0auth.entity.User;
import dev.nano.springsecurityjwt0auth.entity.UserPrincipal;
import dev.nano.springsecurityjwt0auth.repository.UserRepository;
import dev.nano.springsecurityjwt0auth.service.UserService;
import dev.nano.springsecurityjwt0auth.Util.GenerateUserId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static dev.nano.springsecurityjwt0auth.service.Impl.constant.UserImplConstant.*;
import static dev.nano.springsecurityjwt0auth.entity.enumeration.Role.ROLE_USER;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private GenerateUserId generateUserId;

    @Autowired
    public UserServiceImpl(
        UserRepository userRepository,
        BCryptPasswordEncoder passwordEncoder,
        GenerateUserId generateUserId
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.generateUserId = generateUserId;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + username);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + username);
        } else {
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            return userPrincipal;
        }
    }

    @Override
    public User register(String firstName, String lastName, String username, String email) {

        // TODO: Check if username or email already exist
        User user = new User();
        user.setUserId(generateUserId.generateStringId(32));
        String password = generateUserId.generateStringId(8);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setEnabled(true);
        user.setNotLocked(true);
        user.setPassword(encodePassword(password));
        user.setRole(ROLE_USER.name());
        user.setAuthorities(ROLE_USER.getAuthorities());
        userRepository.save(user);
        LOGGER.info("New user password: " + password);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
