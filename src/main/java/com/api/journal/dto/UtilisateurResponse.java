package com.api.journal.dto;

public class UtilisateurResponse {
    private Long id;

    private String username;

    public UtilisateurResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UtilisateurResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
