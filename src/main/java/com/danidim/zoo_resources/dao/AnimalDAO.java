package com.danidim.zoo_resources.dao;

import com.danidim.zoo_resources.entity.Animal;
import java.util.List;

public interface AnimalDAO {
    public List<Animal> getAllAnimals();
    public Animal getAnimal(int id);
    public void saveAnimal(Animal animal);
    public void deleteAnimal(int id);
    public void deleteAllAnimals();
    public void deleteSomeAnimals();

}
