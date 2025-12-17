package com.api.journal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.journal.entity.Journal;
import com.api.journal.repository.JournalRepository;

public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public Iterable<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    public Journal getJournalById(Long id) {
        return journalRepository.findById(id).orElse(null);
    }

    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public void deleteJournal(Long id) {
        journalRepository.deleteById(id);
    }

    public void updateJournal(Long id, Journal updatedJournal) {
        Journal existingJournal = journalRepository.findById(id).orElse(null);
        if (existingJournal != null) {
            existingJournal.setTitle(updatedJournal.getTitle());
            existingJournal.setContent(updatedJournal.getContent());
            existingJournal.setAuthor(updatedJournal.getAuthor());
            journalRepository.save(existingJournal);
        }
    }
}
