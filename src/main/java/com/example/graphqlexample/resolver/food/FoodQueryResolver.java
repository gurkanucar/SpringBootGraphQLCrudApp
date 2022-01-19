package com.example.graphqlexample.resolver.food;

import com.example.graphqlexample.dto.FoodDTO;
import com.example.graphqlexample.dto.converter.FoodConverter;
import com.example.graphqlexample.service.FoodService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodQueryResolver implements GraphQLQueryResolver {

    private final FoodService foodService;
    private final FoodConverter converter;

    public FoodQueryResolver(FoodService foodService,
                             FoodConverter converter) {
        this.foodService = foodService;
        this.converter = converter;
    }

    public List<FoodDTO> getAllFoods() {
        return converter.foodToDto(foodService.getAllFoods());
    }

    public FoodDTO getFoodByID(Long id){
        return converter.foodToDto(foodService.getByID(id));
    }

}
