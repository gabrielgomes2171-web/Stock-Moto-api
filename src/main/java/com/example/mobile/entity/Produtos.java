package com.example.mobile.entity;

import java.time.LocalDateTime;

public class Produtos {

    private String id;

    private String nome;
    private String descricao;
    private String codigo;
    private String categoria;
    private String marca;
    private String modelo_moto;
    private String localizacao;

    private Double preco_custo;
    private Double preco_venda;

    private Integer estoque_minimo;
    private Integer quantidade;

    private LocalDateTime criado_em;

    private String imagem;

    private String usuarioId;

    public Produtos() {
        this.criado_em = LocalDateTime.now();
    }

    public Produtos(String id, String nome, String descricao, String codigo,
            String categoria, String marca, String modelo_moto,
            String localizacao, Double preco_custo, Double preco_venda,
            Integer estoque_minimo, String imagem,
            Integer quantidade, String usuarioId) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo_moto = modelo_moto;
        this.localizacao = localizacao;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.estoque_minimo = estoque_minimo;
        this.imagem = imagem;
        this.quantidade = quantidade;
        this.usuarioId = usuarioId;

        this.criado_em = LocalDateTime.now();
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

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo_moto() {
        return modelo_moto;
    }
    public void setModelo_moto(String modelo_moto) {
        this.modelo_moto = modelo_moto;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Double getPreco_custo() {
        return preco_custo;
    }
    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Integer getEstoque_minimo() {
        return estoque_minimo;
    }
    public void setEstoque_minimo(Integer estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getCriado_em() {
        return criado_em;
    }
    public void setCriado_em(LocalDateTime criado_em) {
        this.criado_em = criado_em;
    }

    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}