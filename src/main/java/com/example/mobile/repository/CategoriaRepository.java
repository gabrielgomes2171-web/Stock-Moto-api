package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mobile.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}


