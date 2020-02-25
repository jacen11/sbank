package com.sbank.service;

import com.sbank.model.Role;
import com.sbank.model.User;
import com.sbank.repostory.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService,  UserDetailsService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(ClientRepository clientRepository,
                           PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createClient(User user) {

        User userFromDb = clientRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return new User();
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //TODO отправка сообщения на почту

        return clientRepository.save(user);
    }

    @Override
    public User getClient(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = clientRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
