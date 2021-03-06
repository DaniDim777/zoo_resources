package com.danidim.zoo_resources.service;

import com.danidim.zoo_resources.dao.AnimalDAO;
import com.danidim.zoo_resources.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalDAO animalDAO;

    @Override
    @Transactional
    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }

    @Override
    @Transactional
    public Animal getAnimal(int id) {
        return animalDAO.getAnimal(id);
    }

    @Override
    @Transactional
    public void saveAnimal(Animal animal) {
        animalDAO.saveAnimal(animal);
    }

    @Override
    @Transactional
    public void deleteAnimal(int id) {
        animalDAO.deleteAnimal(id);
    }

    @Override
    @Transactional
    public void deleteAllAnimals() {
        animalDAO.deleteAllAnimals();
    }

    @Override
    @Transactional
    public void deleteSomeAnimals() {
        animalDAO.deleteSomeAnimals();
    }
}
