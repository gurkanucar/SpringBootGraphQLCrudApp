package com.example.graphqlexample.service;

import com.example.graphqlexample.exception.FoodNotFoundEception;
import com.example.graphqlexample.model.Food;
import com.example.graphqlexample.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getByID(Long id) {

        return foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundEception("food not found"));
    }

    public Food create(Food food) {
        return foodRepository.save(food);
    }

    public Food update(Food food) {
        Food existing = foodRepository.findById(food.getId())
                .orElseThrow(() -> new FoodNotFoundEception("food not found"));
        existing.setName(food.getName());
        existing.setRecipe(food.getRecipe());
        existing.setCategories(food.getCategories());
        return foodRepository.save(existing);
    }

    public Food delete(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundEception("food not found"));
        foodRepository.delete(food);
        return food;
    }


}
