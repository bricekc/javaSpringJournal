package com.api.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
