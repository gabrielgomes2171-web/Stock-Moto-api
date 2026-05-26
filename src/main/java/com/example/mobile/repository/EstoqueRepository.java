package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mobile.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}


