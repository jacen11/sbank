package com.sbank.sbank.service;

import com.sbank.sbank.model.Account;
import com.sbank.sbank.model.Transfer;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account createAccount(Account account);

    Account getAccount(Long accountId);
}
