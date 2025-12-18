package com.api.journal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.journal.entity.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

    List<Utilisateur> findByUsername(String username);
}
