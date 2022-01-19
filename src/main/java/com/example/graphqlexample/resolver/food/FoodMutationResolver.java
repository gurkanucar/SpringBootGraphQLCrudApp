package com.example.graphqlexample.resolver.food;

import com.example.graphqlexample.dto.FoodDTO;
import com.example.graphqlexample.dto.converter.FoodConverter;
import com.example.graphqlexample.model.Food;
import com.example.graphqlexample.service.FoodService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class FoodMutationResolver implements GraphQLMutationResolver {

    private final FoodService foodService;
    private final FoodConverter converter;

    public FoodMutationResolver(FoodService foodService,
                                FoodConverter converter) {
        this.foodService = foodService;
        this.converter = converter;
    }

    public FoodDTO addFood(FoodDTO foodRequest) {
        Food food = converter.dtoToFood(foodRequest);
        return converter.foodToDto(foodService.create(food));
    }

    public FoodDTO updateFood(FoodDTO foodDTO) {
        Food food = converter.dtoToFood(foodDTO);
        return converter.foodToDto(foodService.update(food));
    }

    public FoodDTO deleteFood(Long id) {
        return converter.foodToDto(foodService.delete(id));
    }


}
