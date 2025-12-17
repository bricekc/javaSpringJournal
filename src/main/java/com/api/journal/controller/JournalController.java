package com.api.journal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JournalController {
  @GetMapping(value = "/health")
  public String get() {
    return "coucou";
  }
}
