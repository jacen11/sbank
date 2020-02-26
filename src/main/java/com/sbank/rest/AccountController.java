package com.sbank.rest;

import com.sbank.model.Account;
import com.sbank.model.User;
import com.sbank.service.AccountService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccount(@Min(1) @PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping
    public Account createAccount(@AuthenticationPrincipal User user, @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account account) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return accountService.updateAccount(account);
    }

    @GetMapping
    public Iterable<Account> findAll() {
        return accountService.findAll();
    }
}
