package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mobile.entity.Orcamentos;

public interface EstoqueRepository extends JpaRepository<Orcamentos, Long> {
}


