package org.example.universe.controllers;

import lombok.RequiredArgsConstructor;
import org.example.universe.models.Planet;
import org.example.universe.models.Ruler;
import org.example.universe.repositories.PlanetRepository;
import org.example.universe.repositories.RulerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/planet")
public class PlanetController {
    private final PlanetRepository planetRepo;
    private final RulerRepository rulerRepo;

    @GetMapping()
    public String main(Map<String, Object> map) {
        map.put("planets", planetRepo.findAll());
        return "planet/mainPlanet";
    }

    @GetMapping("/newPlanet")
    public String newPlanet(Map<String, Object> map) {
        map.put("planet", new Planet());
        return "planet/newPlanet";
    }

    @PostMapping("/newPlanet")
    public String create(@ModelAttribute("planet") Planet planet) {
        planetRepo.save(planet);
        return "redirect:/planet";
    }



    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name) {
        Ruler ruler=planetRepo.findByName(name).getRuler();
        ruler.removePlanet(planetRepo.findByName(name));
        planetRepo.delete(planetRepo.findByName(name));
        return "redirect:/planet";
    }

}
