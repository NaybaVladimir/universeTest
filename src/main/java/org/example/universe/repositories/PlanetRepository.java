package org.example.universe.repositories;

import org.example.universe.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository <Planet,String> {
    Planet findByName(String name);
}
