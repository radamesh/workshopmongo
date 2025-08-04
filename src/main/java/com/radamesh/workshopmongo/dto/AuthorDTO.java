package com.radamesh.workshopmongo.dto;

import com.radamesh.workshopmongo.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
