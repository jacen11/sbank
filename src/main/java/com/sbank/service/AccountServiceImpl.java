package com.sbank.service;

import com.sbank.model.Account;
import com.sbank.repostory.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;

    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public Account createAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account getAccount(Long accountId) {
        return repo.findById(accountId).orElse(null);
    }
}
