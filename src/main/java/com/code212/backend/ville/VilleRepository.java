package com.code212.backend.ville;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

    Optional<Ville> findByName(String name);
}
