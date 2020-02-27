package com.sbank.service;

import com.sbank.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account createAccount(Long userId, Account account);

    Account updateAccount(Account account);

    Account getAccount(Long id, Long accountId);

   Iterable<Account> findAll();
}
