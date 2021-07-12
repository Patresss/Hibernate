package com.globallogic.javaacademy.hibernate.onetoone.controller;


import com.globallogic.javaacademy.hibernate.onetoone.entity.Car;
import com.globallogic.javaacademy.hibernate.onetoone.entity.Engine;
import com.globallogic.javaacademy.hibernate.onetoone.repository.CarRepository;
import com.globallogic.javaacademy.hibernate.onetoone.repository.EngineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarRepository carRepository;
    private final EngineRepository engineRepository;

    public CarController(CarRepository carRepository, EngineRepository engineRepository) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestParam String name, @RequestParam Long engineId) {
        Car car = new Car();
        Engine engine = engineRepository.findById(engineId).orElseThrow();
        car.setEngine(engine);
        car.setName(name);
        return carRepository.save(car);
    }


    @PostMapping("/default")
    public Car createCar(@RequestParam String name) {
        Car car = new Car();
        Engine engine = new Engine();
        engine.setName("My engine");
        car.setEngine(engine);
        car.setName(name);
        return carRepository.save(car);
    }


}
