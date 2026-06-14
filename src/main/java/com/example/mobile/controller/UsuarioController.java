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

import com.example.mobile.entity.Usuarios;
import com.example.mobile.service.UsuariosService;

@RestController
@RequestMapping("/conta")
public class UsuarioController {

    private final UsuariosService usuariosService;

    public UsuarioController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public ResponseEntity<String> criarConta(
            @RequestBody Usuarios usuario) {

        try {
            String uid = usuariosService.salvar(usuario);

            return ResponseEntity
                    .status(201)
                    .body("Usuário criado com sucesso. ID: " + uid);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao criar usuário: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios() {

        try {
            return ResponseEntity.ok(
                    usuariosService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Usuarios> buscarUsuario(
            @PathVariable String uid) {

        try {
            Usuarios usuario =
                    usuariosService.buscarPorId(uid);

            if (usuario == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{uid}")
    public ResponseEntity<String> atualizarUsuario(
            @PathVariable String uid,
            @RequestBody Usuarios usuario) {

        try {
            usuario.setUid(uid);
            usuariosService.salvar(usuario);

            return ResponseEntity.ok(
                    "Usuário atualizado com sucesso");

        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> excluirUsuario(
            @PathVariable String uid) {

        try {
            usuariosService.excluir(uid);
            
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}