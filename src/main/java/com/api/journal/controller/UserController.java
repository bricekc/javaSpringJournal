package com.api.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.journal.dto.UtilisateurResponse;
import com.api.journal.entity.Utilisateur;
import com.api.journal.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<UtilisateurResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UtilisateurResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public UtilisateurResponse createUser(@RequestBody Utilisateur user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Utilisateur updatedUser) {
        userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
