package com.danidim.zoo_resources.controller;

import com.danidim.zoo_resources.entity.Food;
import com.danidim.zoo_resources.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public List<Food> showAllFoods() {
        List<Food> allFoods = foodService.getAllFoods();
        return allFoods;
    }

    @GetMapping("/foods/{id}")
    public Food getFood(@PathVariable int id) {
        Food food = foodService.getFood(id);
        return food;
    }

    @PostMapping("/foods")
    public Food addNewFood(@RequestBody Food food) {
        foodService.saveFood(food);
        return food;
    }

    @PutMapping("/foods/{id}")
    public Food updateFood(@PathVariable int id, @RequestBody Food food) {
        foodService.saveFood(food);
        return food;
    }

    @DeleteMapping("/foods/{id}")
    public String deleteFood(@PathVariable int id) {
        Food food = foodService.getFood(id);
        foodService.deleteFood(id);
        return "Food with ID = " + id + " was deleted";
    }

    @DeleteMapping("/foods")
    public String deleteAllFoods() {
        List<Food> allFoods = foodService.getAllFoods();
        foodService.deleteAllFoods();
        return "All Foods was deleted";
    }

    @DeleteMapping("/foodz")
    public String deleteSomeFoods() {
        foodService.deleteSomeFoods();
        return "Foods with 'Pieces' measure was deleted";
    }
}
