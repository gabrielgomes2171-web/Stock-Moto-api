package com.example.mobile.controller;

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

import com.example.mobile.entity.Produtos;


@RestController
public class ProdutosController {

    private final List<Produtos> produtos = new ArrayList<>();

    @PostMapping("/produtos")
    public ResponseEntity<String> criarProduto(@RequestBody Produtos produto) {
        produtos.add(produto);
        return ResponseEntity.status(201).body("Seu produto foi enviado com sucesso!");
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produtos>> getProdutos() {
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<String> atualizarProduto(
            @PathVariable Integer id,
            @RequestBody Produtos produtoAtualizado) {

        for (Produtos p : produtos) {

            if (p.getId().equals(id)) {

                p.setNome(produtoAtualizado.getNome());
                p.setDescricao(produtoAtualizado.getDescricao());
                p.setCodigo(produtoAtualizado.getCodigo());
                p.setCategoria(produtoAtualizado.getCategoria());
                p.setMarca(produtoAtualizado.getMarca());
                p.setModelo_moto(produtoAtualizado.getModelo_moto());
                p.setLocalizacao(produtoAtualizado.getLocalizacao());
                p.setPreco_custo(produtoAtualizado.getPreco_custo());
                p.setPreco_venda(produtoAtualizado.getPreco_venda());
                p.setEstoque_minimo(produtoAtualizado.getEstoque_minimo());

                return ResponseEntity.ok("Produto atualizado com sucesso!");
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {

        Iterator<Produtos> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produtos p = iterator.next();

            if (p.getId().equals(id)) {
                iterator.remove();
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}