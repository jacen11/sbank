package com.sbank.service;

import com.sbank.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createClient(User user);

    User getClient(Long clientId);
}
