package com.code212.backend.specialite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

    Optional<Specialite> findByName(String name);
}
