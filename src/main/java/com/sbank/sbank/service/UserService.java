package com.sbank.sbank.service;

import com.sbank.sbank.model.User;
import com.sbank.sbank.model.web.WebUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    WebUser createClient(User user);

    WebUser getClient(Long clientId);
}
