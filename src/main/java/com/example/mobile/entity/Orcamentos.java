package com.example.mobile.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamentos")
public class Orcamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String cliente_nome;

	private LocalDateTime criado_em;
	private String telefone;
	private String moto;
	private Integer validade;
	private String observacoes;
	private Integer total;
	private String status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuarios usuario;

	public Orcamentos(Integer id, String cliente_nome, LocalDateTime criado_em,
			String telefone, String moto, Integer validade,
			String observacoes, Integer total, String status,
			Usuarios usuario) {

		this.id = id;
		this.cliente_nome = cliente_nome;
		this.criado_em = criado_em;
		this.telefone = telefone;
		this.moto = moto;
		this.validade = validade;
		this.observacoes = observacoes;
		this.total = total;
		this.status = status;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
}