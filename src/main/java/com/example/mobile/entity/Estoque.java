package com.example.mobile.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer quantidade;
    private LocalDateTime atualizado_em;
    
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produtos produto;

	public Integer getquantidade() {
		return quantidade;
	}

	public void setquantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getAtualizado_em() {
		return atualizado_em;
	}

	public void setAtualizado_em(LocalDateTime atualizado_em) {
		this.atualizado_em = atualizado_em;
	}
}
