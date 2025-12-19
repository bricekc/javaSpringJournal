package com.api.journal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.journal.dto.UtilisateurResponse;
import com.api.journal.entity.Utilisateur;
import com.api.journal.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UtilisateurResponse> getAllUsers() {
        List<UtilisateurResponse> utilisateurResponses = new ArrayList<>();
        for (Utilisateur utilisateur : userRepository.findAll()) {
            utilisateurResponses.add(convertUtilisateurEntityIntoResponse(utilisateur));
        }
        return utilisateurResponses;
    }

    public UtilisateurResponse getUserById(Long id) {
        return convertUtilisateurEntityIntoResponse(userRepository.findById(id).orElse(null));
    }

    public UtilisateurResponse createUser(Utilisateur user) {
        return convertUtilisateurEntityIntoResponse(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, Utilisateur updatedUser) {
        Utilisateur existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            userRepository.save(existingUser);
        }
    }

    public UtilisateurResponse convertUtilisateurEntityIntoResponse(Utilisateur utilisateur) {
        return new UtilisateurResponse(utilisateur.getId(), utilisateur.getUsername());
    }
}
