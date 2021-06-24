package org.example.universe.controllers;

import lombok.RequiredArgsConstructor;
import org.example.universe.models.Planet;
import org.example.universe.models.Ruler;
import org.example.universe.repositories.PlanetRepository;
import org.example.universe.repositories.RulerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ruler")
public class RulerController {
    private final PlanetRepository planetRepo;
    private final RulerRepository rulerRepo;

    @GetMapping()
    public String main(Map<String, Object> map) {
        map.put("rulers", rulerRepo.findAll());
        return "ruler/mainRuler";
    }

    @GetMapping("/newRuler")
    public String newRuler(Map<String, Object> map) {
        map.put("ruler", new Ruler());
        map.put("planets", planetRepo.findAll());
        return "ruler/newRuler";
    }

    @PostMapping("/newRuler")
    public String create(@ModelAttribute("ruler") Ruler ruler) {
        rulerRepo.save(ruler);
        return "redirect:/ruler";
    }

    @GetMapping("/edit/{name}")
    public String edit(@PathVariable("name") String name, Map<String, Object> map) {
        map.put("ruler", rulerRepo.findByName(name));
        return "ruler/editRuler";
    }

    @PatchMapping("/edit/{name}")
    public String update(@ModelAttribute("ruler") Ruler ruler) {
        rulerRepo.save(ruler);
        return "redirect:/ruler";
    }

    @GetMapping("/planet/{name}")
    public String rulerPlanet(@PathVariable("name") String name, Map<String, Object> map) {
        map.put("ruler", rulerRepo.findByName(name));
        map.put("planets", planetRepo.findAll());
        return "ruler/rulerPlanets";
    }

    @PatchMapping("/planet/{name}")
    public String createRulerPlanet(@PathVariable("name") String name, @RequestParam("planet") List<String> planet) {
        Ruler ruler = rulerRepo.findByName(name);
        for (String el : planet) {
            Planet planet1 = planetRepo.findByName(el);
            ruler.addPlanet(planet1);
            planet1.setRuler(ruler);
            planetRepo.save(planet1);
        }
        rulerRepo.save(ruler);

        return "redirect:/ruler";
    }

    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name) {
        Ruler ruler = rulerRepo.findByName(name);
        if (ruler.getPlanets().size() > 0)
            for (Planet el : ruler.getPlanets()) {
                el.removeRuler();
            }
        rulerRepo.delete(ruler);
        return "redirect:/ruler";
    }

    @PatchMapping("/deletePlanet/{name}")
    public String deletePlanet(@PathVariable("name") String name, @RequestParam("planets") List<String> planets) {

        Ruler ruler = rulerRepo.findByName(name);
        for (String el : planets) {
            Planet planet = planetRepo.findByName(el);
            ruler.removePlanet(planet);
            planet.removeRuler();
            planetRepo.save(planet);
        }
        rulerRepo.save(ruler);
        return "redirect:/ruler";
    }

    @GetMapping("/freeRulers")
    public String freeRulers(Map<String, Object> map) {
        List<Ruler> list = new ArrayList<>();
        for (Ruler el : rulerRepo.findAll())
            if (el.getPlanets().size() < 1)
                list.add(el);
        map.put("rulers", list);
        return "ruler/mainRuler";
    }

    @GetMapping("/top")
    public String top(Map<String, Object> map) {
        List<Ruler> allRuler = rulerRepo.findAll();
        List<Ruler> topRuler = new ArrayList<>();
        allRuler.sort(new Comparator<Ruler>() {
            @Override
            public int compare(Ruler o1, Ruler o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        if (allRuler.size()>=10)
        for(int i=0;i<10;i++)
        {topRuler.add(allRuler.get(i));
        map.put("rulers", topRuler);}
        else
            map.put("rulers", allRuler);

        return "ruler/mainRuler";
    }
}
