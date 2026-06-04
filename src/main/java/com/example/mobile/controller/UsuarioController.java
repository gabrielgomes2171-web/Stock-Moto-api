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

import com.example.mobile.entity.Usuarios;

		@RestController
		public class UsuarioController {
			List<Usuarios> contas = new ArrayList<>();
			
			@PostMapping("/conta")
			public ResponseEntity<String> criarConta(@RequestBody Usuarios conta) {
				contas.add(conta);
				return ResponseEntity.status(201).body("Sua conta foi criada com sucesso");
			}
			
			@DeleteMapping("/conta/{id}")
			public ResponseEntity<Void> deleteContato(@PathVariable int id) {
			    for (Usuarios c : contas) {
			        if (c.getUid() == id) {
			            contas.remove(c);
			            return ResponseEntity.noContent().build();
			        }
			    }
			    return ResponseEntity.notFound().build();
			}
			
			@PutMapping("/conta/{id}")
			public ResponseEntity<String> putConta(@PathVariable int id, @RequestBody Usuarios updatedConta) {
			    for (Usuarios c : contas) {
			        if (c.getUid() == id) {
			            c.setNome(updatedConta.getNome());
			            c.setEmail(updatedConta.getEmail());
			            c.setSenha(updatedConta.getSenha());
			            return ResponseEntity.ok("Suas informações foram atualizadas!");
			        }
			    }
			    return ResponseEntity.notFound().build();
			}
			@GetMapping("/conta")
			public ResponseEntity<List<Usuarios>> getConta() {
			    return ResponseEntity.ok(contas);
			}

		}

