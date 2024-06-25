package com.api.apiinterface.controller;

import com.api.apiinterface.model.User;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "get, your name: " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "post, your name: " + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user) {
        return "post, your username: " + user.getUsername();
    }
}
