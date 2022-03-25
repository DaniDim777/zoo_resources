package com.danidim.zoo_resources.dao;

import com.danidim.zoo_resources.entity.Food;

import java.util.List;

public interface FoodDAO {
    public List<Food> getAllFoods();
    public Food getFood(int id);
    public void saveFood(Food food);
    public void deleteFood(int id);
    public void deleteAllFoods();
    public void deleteSomeFoods();
}
