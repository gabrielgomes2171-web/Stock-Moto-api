package com.example.mobile.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @Column(nullable = false)
    private String codigo;
    private String categoria;
    private String marca;
    private String modelo_moto;
    private String localizacao;
    private Float preco_custo;
    private Float preco_venda;
    private Integer estoque_minimo;
    private LocalDateTime criado_em;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Float getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(Float preco_custo) {
		this.preco_custo = preco_custo;
	}

	public Float getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Float preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Integer getEstoque_minimo() {
		return estoque_minimo;
	}

	public void setEstoque_minimo(Integer estoque_minimo) {
		this.estoque_minimo = estoque_minimo;
	}

	public LocalDateTime getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(LocalDateTime criado_em) {
		this.criado_em = criado_em;
	}}