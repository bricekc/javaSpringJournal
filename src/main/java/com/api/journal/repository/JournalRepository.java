package com.api.journal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.journal.entity.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    List<Journal> findByUtilisateurId(Long utilisateurId);

}
