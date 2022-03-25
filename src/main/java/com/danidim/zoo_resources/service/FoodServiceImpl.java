package com.danidim.zoo_resources.service;

import com.danidim.zoo_resources.dao.FoodDAO;
import com.danidim.zoo_resources.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDAO foodDAO;

    @Override
    @Transactional
    public List<Food> getAllFoods() {
        return foodDAO.getAllFoods();
    }

    @Override
    @Transactional
    public Food getFood(int id) {
        return foodDAO.getFood(id);
    }

    @Override
    @Transactional
    public void saveFood(Food food) {
        foodDAO.saveFood(food);
    }

    @Override
    @Transactional
    public void deleteFood(int id) {
        foodDAO.deleteFood(id);
    }

    @Override
    @Transactional
    public void deleteAllFoods() {
        foodDAO.deleteAllFoods();
    }

    @Override
    @Transactional
    public void deleteSomeFoods() {
        foodDAO.deleteSomeFoods();
    }
}
