package com.sbank.service;

import com.sbank.model.User;
import com.sbank.model.web.WebUser;
import com.sbank.repostory.ClientRepository;
import com.sbank.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final ClientRepository clientRepository;

    public UserServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public WebUser createClient(User user) {
        return null;
        //clientRepository.save(user);
    }

    @Override
    public WebUser getClient(Long clientId) {
        return null;
                //clientRepository.findById(clientId).orElse(null);
    }
}
