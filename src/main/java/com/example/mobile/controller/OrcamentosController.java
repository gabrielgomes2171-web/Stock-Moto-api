package com.example.mobile.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobile.entity.Orcamentos;
import com.example.mobile.service.OrcamentosService;

@RestController
@RequestMapping("/orcamento")
public class OrcamentosController {

    private final OrcamentosService orcamentosService;

    public OrcamentosController(
            OrcamentosService orcamentosService) {
				
        this.orcamentosService = orcamentosService;
    }

    @PostMapping
    public ResponseEntity<String> criarOrcamento(
            @RequestBody Orcamentos orcamento) {

        try {
            String id =
                    orcamentosService.salvar(orcamento);

            return ResponseEntity
                    .status(201)
                    .body("Orçamento criado com sucesso. ID: " + id);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao criar orçamento: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Orcamentos>> listarOrcamentos() {

        try {
            return ResponseEntity.ok(
                    orcamentosService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orcamentos> buscarOrcamento(
            @PathVariable String id) {

        try {
            Orcamentos orcamento =
                    orcamentosService.buscarPorId(id);

            if (orcamento == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(orcamento);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarOrcamento(
            @PathVariable String id,
            @RequestBody Orcamentos orcamento) {

        try {
            orcamento.setId(id);
            orcamentosService.salvar(orcamento);

            return ResponseEntity.ok(
                    "Orçamento atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao atualizar orçamento: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirOrcamento(
            @PathVariable String id) {

        try {
            orcamentosService.excluir(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}