package com.sbank.rest;

import com.sbank.model.User;
import com.sbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public @ResponseBody
    User getTestData(@Min(1) @PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public User createClient(@RequestBody User user) {
        return userService.createUser(user);
    }
}
