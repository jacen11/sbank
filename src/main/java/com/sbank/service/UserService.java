package com.sbank.service;

import com.sbank.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(User user);

    User getUser(Long clientId);
}
