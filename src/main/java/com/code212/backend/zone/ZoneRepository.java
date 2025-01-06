package com.code212.backend.zone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

    Optional<Zone> findByName(String name);
}
