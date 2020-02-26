package com.sbank.service;

import com.sbank.model.Role;
import com.sbank.model.User;
import com.sbank.repostory.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService,  UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {

        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            //todo подумать что возвращать когда имя такое уже есть
            return new User();
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //TODO отправка сообщения на почту

        return userRepository.save(user);
    }

    @Override
    public User getUser(Long clientId) {
        return userRepository.findById(clientId).orElse(new User());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
