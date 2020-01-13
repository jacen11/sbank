package com.sbank.rest;

import com.sbank.model.User;
import com.sbank.model.User;
import com.sbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String start() {

        return "test";
    }

    @GetMapping("/user/{userId}")
    public @ResponseBody
    User getTestData(@PathVariable Long userId) {
        return userService.getClient(userId);
    }

    @PostMapping("/createUser")
    public User createClient(@Valid User user) {
        return userService.createClient(user);
    }
}
