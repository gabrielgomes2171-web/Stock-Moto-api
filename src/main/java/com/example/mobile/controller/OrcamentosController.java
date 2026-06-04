package com.example.mobile.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobile.entity.Orcamentos;

@RestController
public class OrcamentosController {

	List<Orcamentos> orcamentos = new ArrayList<>();

	@PostMapping("/orcamento")
	public ResponseEntity<String> criarOrcamento(@RequestBody Orcamentos orcamento) {
		orcamento.setCriado_em(LocalDateTime.now());
		orcamentos.add(orcamento);
		return ResponseEntity.status(201).body("Seu orçamento foi criado!");
	}

	@DeleteMapping("/orcamento/{id}")
	public ResponseEntity<Void> deleteOrcamento(@PathVariable int id) {
		for (Orcamentos o : orcamentos) {
			if (o.getId() == id) {
				orcamentos.remove(o);
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/orcamento/{id}")
	public ResponseEntity<String> putOrcamento(@PathVariable int id,
			@RequestBody Orcamentos updatedOrcamento) {

		for (Orcamentos o : orcamentos) {
			if (o.getId() == id) {

				o.setCliente_nome(updatedOrcamento.getCliente_nome());
				o.setTelefone(updatedOrcamento.getTelefone());
				o.setMoto(updatedOrcamento.getMoto());
				o.setValidade(updatedOrcamento.getValidade());
				o.setObservacoes(updatedOrcamento.getObservacoes());
				o.setTotal(updatedOrcamento.getTotal());
				o.setStatus(updatedOrcamento.getStatus());
				o.setUsuario(updatedOrcamento.getUsuario());
				o.setCriado_em(LocalDateTime.now());

				return ResponseEntity.ok("Orçamento atualizado!");
			}
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/orcamento")
	public ResponseEntity<List<Orcamentos>> getOrcamento() {
		return ResponseEntity.ok(orcamentos);
	}
}