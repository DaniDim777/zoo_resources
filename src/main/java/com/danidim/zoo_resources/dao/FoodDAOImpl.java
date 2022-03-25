package com.danidim.zoo_resources.dao;

import com.danidim.zoo_resources.entity.Food;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FoodDAOImpl implements FoodDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Food> getAllFoods() {
        Session session = entityManager.unwrap(Session.class);
        Query<Food> query = session.createQuery("from Food", Food.class);
        List<Food> allFoods = query.getResultList();
        return allFoods;
    }

    @Override
    public Food getFood(int id) {
        Session session = entityManager.unwrap(Session.class);
        Food food = session.get(Food.class, id);
        return food;
    }

    @Override
    public void saveFood(Food food) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(food);
    }

    @Override
    public void deleteFood(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Food> query = session.createQuery("delete from " +
                "Food where id =:foodId");
        query.setParameter("foodId", id);
        query.executeUpdate();
    }

    @Override
    public void deleteAllFoods() {
        Session session = entityManager.unwrap(Session.class);
        Query<Food> query = session.createQuery("delete from Food");
        query.executeUpdate();
    }

    @Override
    public void deleteSomeFoods() {
        Session session = entityManager.unwrap(Session.class);
        Query<Food> query = session.createQuery("delete from Food " +
                "where measure = 'Pieces'");
        query.executeUpdate();
    }
}
