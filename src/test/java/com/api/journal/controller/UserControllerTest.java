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

import com.api.journal.entity.Utilisateur;
import com.api.journal.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllUsers() throws Exception {
        Utilisateur user1 = new Utilisateur();
        user1.setId(1L);
        Utilisateur user2 = new Utilisateur();
        user2.setId(2L);
        Iterable<Utilisateur> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserById() throws Exception {
        Utilisateur user = new Utilisateur();
        user.setId(1L);

        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateUser() throws Exception {
        Utilisateur user = new Utilisateur();
        user.setId(1L);

        when(userService.createUser(any(Utilisateur.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1}")) // Adjust JSON
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUser() throws Exception {
        Utilisateur updatedUser = new Utilisateur();
        updatedUser.setId(1L);

        doNothing().when(userService).updateUser(eq(1L), any(Utilisateur.class));

        mockMvc.perform(put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isOk());
    }
}