package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mobile.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}