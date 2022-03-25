package com.danidim.zoo_resources.controller;

import com.danidim.zoo_resources.entity.Animal;
import com.danidim.zoo_resources.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public List<Animal> showAllAnimals() {
        List<Animal> allAnimals = animalService.getAllAnimals();
        return allAnimals;
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimal(@PathVariable int id) {
        Animal animal = animalService.getAnimal(id);
        return animal;
    }

    @PostMapping("/animals")
    public Animal addNewAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
        return animal;
    }

    @PutMapping("/animals/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animalService.saveAnimal(animal);
        return animal;
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable int id) {
        Animal animal = animalService.getAnimal(id);
        animalService.deleteAnimal(id);
        return "Animal with ID = " + id + " was deleted";
    }

    @DeleteMapping("/animals")
    public String deleteAllAnimals() {
        List<Animal> allAnimals = animalService.getAllAnimals();
        animalService.deleteAllAnimals();
        return "All Animals was deleted";
    }

    @DeleteMapping("/animalz")
    public String deleteSomeAnimals() {
        animalService.deleteSomeAnimals();
        return "Animals with Predator type equals false was deleted";
    }
}
