package com.example.mobile.entity;

import java.time.LocalDateTime;

public class Orcamentos {

    private String id;
    private String cliente_nome;
    private LocalDateTime criado_em;
    private String telefone;
    private String moto;
    private Integer validade;
    private String observacoes;
    private Double total;
    private String status;
    private String usuarioId;

    public Orcamentos() {
        this.criado_em = LocalDateTime.now();
    }

    public Orcamentos(String id, String cliente_nome, String telefone, String moto,
            		Integer validade, String observacoes,Double total, String status,String usuarioId) {

        this.id = id;
        this.cliente_nome = cliente_nome;
        this.telefone = telefone;
        this.moto = moto;
        this.validade = validade;
        this.observacoes = observacoes;
        this.total = total;
        this.status = status;
        this.usuarioId = usuarioId;
        this.criado_em = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }
    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }
    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMoto() {
        return moto;
    }
    public void setMoto(String moto) {
        this.moto = moto;
    }

    public Integer getValidade() {
        return validade;
    }
    public void setValidade(Integer validade) {
        this.validade = validade;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}