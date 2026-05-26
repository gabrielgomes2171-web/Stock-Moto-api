package com.example.mobile.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobile.entity.Estoque;

@RestController
public class EstoqueController {

    private final List<Estoque> estoques = new ArrayList<>();

    @PostMapping("/estoque")
    public ResponseEntity<String> criarEstoque(
            @RequestBody Estoque estoque) {

        estoque.setAtualizado_em(LocalDateTime.now());
        estoques.add(estoque);
        return ResponseEntity.status(201).body("Seu estoque foi criado com sucesso!");
    }

    @GetMapping("/estoque")
    public ResponseEntity<List<Estoque>> getEstoque() {

        return ResponseEntity.ok(estoques);
    }

    @PutMapping("/estoque/{id}")
    public ResponseEntity<String> atualizarEstoque(
            @PathVariable Integer id,
            @RequestBody Estoque estoqueAtualizado) {

        for (Estoque e : estoques) {

            if (e.getId().equals(id)) {
                e.setquantidade(estoqueAtualizado.getquantidade());
                e.setProduto(estoqueAtualizado.getProduto());
                e.setAtualizado_em(LocalDateTime.now());
                return ResponseEntity.ok("Estoque atualizado!");
            }
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/estoque/{id}")
    public ResponseEntity<Void> deleteEstoque(
            @PathVariable Integer id) {

        Iterator<Estoque> iterator =
                estoques.iterator();
        while (iterator.hasNext()) {

            Estoque e = iterator.next();
            if (e.getId().equals(id)) {
                iterator.remove();
                return ResponseEntity
                        .noContent()
                        .build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}