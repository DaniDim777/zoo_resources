package com.danidim.zoo_resources.dao;

import com.danidim.zoo_resources.entity.Animal;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Animal> getAllAnimals() {
        Session session = entityManager.unwrap(Session.class);
        Query<Animal> query = session.createQuery("from Animal", Animal.class);
        List<Animal> allAnimals = query.getResultList();
        return allAnimals;
    }

    @Override
    public Animal getAnimal(int id) {
        Session session = entityManager.unwrap(Session.class);
        Animal animal = session.get(Animal.class, id);
        return animal;
    }

    @Override
    public void saveAnimal(Animal animal) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(animal);
    }

    @Override
    public void deleteAnimal(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Animal> query = session.createQuery("delete from " +
                "Animal where id =:animalId");
        query.setParameter("animalId", id);
        query.executeUpdate();
    }

    @Override
    public void deleteAllAnimals() {
        Session session = entityManager.unwrap(Session.class);
        Query<Animal> query = session.createQuery("delete from Animal");
        query.executeUpdate();
    }

    @Override
    public void deleteSomeAnimals() {
        Session session = entityManager.unwrap(Session.class);
        Query<Animal> query = session.createQuery("delete from Animal " +
                "where isPredator =:isPredator");
        query.setParameter("isPredator", false);
        query.executeUpdate();
    }
}
