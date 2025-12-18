package com.api.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.journal.entity.Journal;
import com.api.journal.service.JournalService;

@RestController
public class JournalController {

  @Autowired
  private JournalService journalService;

  @GetMapping(value = "/health")
  public String get() {
    return "coucou";
  }

  @GetMapping(value = "/")
  public String home() {
    return "Bienvenue sur l'API Journal!";
  }

  @GetMapping("/journals")
  public Iterable<Journal> getAllJournals() {
    return journalService.getAllJournals();
  }

  @GetMapping("/journals/{id}")
  public Journal getJournalById(@PathVariable Long id) {
    return journalService.getJournalById(id);
  }

  @PostMapping("/journals")
  public Journal createJournal(@RequestBody Journal journal) {
    return journalService.createJournal(journal);
  }

  @DeleteMapping("/journals/{id}")
  public void deleteJournal(@PathVariable Long id) {
    journalService.deleteJournal(id);
  }

  @PutMapping("/journals/{id}")
  public void updateJournal(@PathVariable Long id, @RequestBody Journal updatedJournal) {
    journalService.updateJournal(id, updatedJournal);
  }

  @GetMapping("/utilisateurs/{utilisateurId}/journals")
  public Iterable<Journal> getJournalsByUtilisateurId(@PathVariable Long utilisateurId) {
    return journalService.getJournalsByUtilisateurId(utilisateurId);
  }
}
