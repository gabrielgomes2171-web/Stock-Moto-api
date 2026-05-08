package com.example.mobile.controller;

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
import com.example.mobile.entity.Conta;

		@RestController
		public class ContaController {
			List<Conta> contas = new ArrayList<Conta>();
			
			@PostMapping("/conta")
			public ResponseEntity<String> criarConta(@RequestBody Conta conta) {
				contas.add(conta);
				return ResponseEntity.status(201).body("Sua conta foi criada com sucesso");
			}
			
			@DeleteMapping("/conta/{id}")
			public ResponseEntity<Void> deleteContato(@PathVariable int id) {
			    for (Conta c : contas) {
			        if (c.getId() == id) {
			            contas.remove(c);
			            return ResponseEntity.noContent().build();
			        }
			    }
			    return ResponseEntity.notFound().build();
			}
			
			@PutMapping("/conta/{id}")
			public ResponseEntity<String> putConta(@PathVariable int id, @RequestBody Conta updatedConta) {
			    for (Conta c : contas) {
			        if (c.getId() == id) {
			            c.setNome(updatedConta.getNome());
			            c.setEmail(updatedConta.getEmail());
			            return ResponseEntity.ok("Suas informações foram atualizadas!");
			        }
			    }
			    return ResponseEntity.notFound().build();
			}
			@GetMapping("/conta")
			public ResponseEntity<List<Conta>> getConta() {
			    return ResponseEntity.ok(contas);
			}

		}

