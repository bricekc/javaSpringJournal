package com.api.journal.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.api.journal.entity.Journal;
import com.api.journal.service.JournalService;

@WebMvcTest(JournalController.class)
public class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JournalService journalService;

    @Test
    public void testGetHealth() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("coucou"));
    }

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Bienvenue sur l'API Journal!"));
    }

    @Test
    public void testGetAllJournals() throws Exception {
        Journal journal1 = new Journal();
        journal1.setId(1L);
        Journal journal2 = new Journal();
        journal2.setId(2L);
        List<Journal> journals = Arrays.asList(journal1, journal2);

        when(journalService.getAllJournals()).thenReturn(journals);

        mockMvc.perform(get("/journals"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetJournalById() throws Exception {
        Journal journal = new Journal();
        journal.setId(1L);

        when(journalService.getJournalById(1L)).thenReturn(journal);

        mockMvc.perform(get("/journals/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateJournal() throws Exception {
        Journal journal = new Journal();
        journal.setId(1L);

        when(journalService.createJournal(any(Journal.class))).thenReturn(journal);

        mockMvc.perform(post("/journals")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteJournal() throws Exception {
        doNothing().when(journalService).deleteJournal(1L);

        mockMvc.perform(delete("/journals/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateJournal() throws Exception {
        Journal updatedJournal = new Journal();
        updatedJournal.setId(1L);

        doNothing().when(journalService).updateJournal(eq(1L), any(Journal.class));

        mockMvc.perform(put("/journals/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetJournalsByUtilisateurId() throws Exception {
        Journal journal = new Journal();
        journal.setId(1L);
        List<Journal> journals = Arrays.asList(journal);

        when(journalService.getJournalsByUtilisateurId(1L)).thenReturn(journals);

        mockMvc.perform(get("/utilisateurs/1/journals"))
                .andExpect(status().isOk());
    }
}