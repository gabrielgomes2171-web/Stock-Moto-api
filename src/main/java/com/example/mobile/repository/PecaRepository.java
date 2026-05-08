package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mobile.entity.Peca;

public interface PecaRepository extends JpaRepository<Peca, Long> {
}

