package com.api.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.api.journal.entity.Utilisateur;
import com.api.journal.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Utilisateur getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public Utilisateur createUser(Utilisateur user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(Long id, Utilisateur updatedUser) {
        userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
