package com.code212.backend.repas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepasRepository extends JpaRepository<Repas, Integer> {

    Optional<Repas> findByName(String name);
}
