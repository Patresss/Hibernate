package com.globallogic.javaacademy.hibernate.onetoone.controller;


import com.globallogic.javaacademy.hibernate.onetoone.entity.Engine;
import com.globallogic.javaacademy.hibernate.onetoone.repository.EngineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("engines")
public class EngineController {

    private final EngineRepository engineRepository;

    public EngineController(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @GetMapping
    public List<Engine> getEngines() {
        return engineRepository.findAll();
    }

    @PostMapping
    public Engine createEngine(@RequestParam String name) {
        Engine engine = new Engine();
        engine.setName(name);
        return engineRepository.save(engine);
    }

}
