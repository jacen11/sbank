package com.sbank.service;

import com.sbank.model.User;
import com.sbank.model.User;
import com.sbank.repostory.ClientRepository;
import com.sbank.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final ClientRepository clientRepository;

    public UserServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public User createClient(User user) {
        return clientRepository.save(user);
    }

    @Override
    public User getClient(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }
}
