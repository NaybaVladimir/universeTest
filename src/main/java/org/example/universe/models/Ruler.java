package org.example.universe.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ruler{
    @Id
    private String name;

    private int age;

    @OneToMany
    private List<Planet> planets;


    public Ruler() {
        planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet){
        this.planets.add(planet);
    }

    public void removePlanet(Planet planet) {
        this.planets.remove(planet);
    }


}
