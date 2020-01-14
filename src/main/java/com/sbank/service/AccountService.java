package com.sbank.service;

import com.sbank.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account createAccount(Account account);

    Account updateAccount(Account account);

    Account getAccount(Long accountId);

   Iterable<Account> findAll();
}
