package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mobile.entity.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}