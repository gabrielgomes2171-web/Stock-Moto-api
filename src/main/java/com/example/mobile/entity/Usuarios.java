package com.example.mobile.entity;

import java.time.LocalDateTime;

public class Usuarios {

    private String uid;
    private String nome;
    private String email;
    private LocalDateTime criado_em;

    public Usuarios() {
        this.criado_em = LocalDateTime.now();
    }

    public Usuarios(String uid, String nome, String email) {
        this.uid = uid;
        this.nome = nome;
        this.email = email;
        this.criado_em = LocalDateTime.now();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }
}