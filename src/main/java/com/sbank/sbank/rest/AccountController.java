package com.sbank.sbank.rest;

import com.sbank.sbank.model.Account;
import com.sbank.sbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String test(){
        return "qwejl";
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }

    @PostMapping
    public Account createAccount(Account account){
        return accountService.createAccount(account);
    }

    @PutMapping
    public Account updateAccount(Account account){
        return accountService.updateAccount(account);
    }
}
