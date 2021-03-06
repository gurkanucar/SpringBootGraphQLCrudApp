package com.example.graphqlexample.dto.converter;

import com.example.graphqlexample.dto.FoodDTO;
import com.example.graphqlexample.model.Food;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodConverter {

    private final CategoryInsideFoodConverter categoryConverter;

    public FoodConverter(CategoryInsideFoodConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }


    public Food dtoToFood(FoodDTO foodDTO){
        return Food.builder()
                .id(foodDTO.getId())
                .name(foodDTO.getName())
                .recipe(foodDTO.getRecipe())
                .categories(categoryConverter.dtoToCategory(foodDTO.getCategories()))
                .build();
    }

    public FoodDTO foodToDto(Food food){
        return FoodDTO.builder()
                .id(food.getId())
                .name(food.getName())
                .recipe(food.getRecipe())
                .categories(categoryConverter.categoryToDto(food.getCategories()))
                .build();
    }

    public List<FoodDTO> foodToDto(List<Food> foods){
       return foods.stream()
               .map(x->foodToDto(x)).collect(Collectors.toList());
    }


}
