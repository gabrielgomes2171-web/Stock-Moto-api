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

import com.example.mobile.entity.Produtos;
import com.example.mobile.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @PostMapping
    public ResponseEntity<String> criarProduto(
            @RequestBody Produtos produto) {

        try {
            String id = produtosService.salvar(produto);

            return ResponseEntity
                    .status(201)
                    .body("Produto criado com sucesso. ID: " + id);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao criar produto: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listarProdutos() {

        try {
            return ResponseEntity.ok(
                    produtosService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarProduto(
            @PathVariable String id) {

        try {
            Produtos produto =
                    produtosService.buscarPorId(id);

            if (produto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(
            @PathVariable String id,
            @RequestBody Produtos produto) {

        try {
            produto.setId(id);
            produtosService.salvar(produto);

            return ResponseEntity.ok(
                    "Produto atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(
            @PathVariable String id) {

        try {
            produtosService.excluir(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}