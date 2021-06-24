package org.example.universe.repositories;

import org.example.universe.models.Ruler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RulerRepository extends JpaRepository <Ruler, String> {
    Ruler findByName(String name);
}
