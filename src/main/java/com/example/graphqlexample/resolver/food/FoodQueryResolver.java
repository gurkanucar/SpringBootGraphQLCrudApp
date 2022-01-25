package com.example.graphqlexample.resolver.food;

import com.example.graphqlexample.dto.FoodDTO;
import com.example.graphqlexample.dto.converter.FoodConverter;
import com.example.graphqlexample.service.FoodService;
import com.github.javaparser.utils.Log;
import graphql.kickstart.tools.GraphQLQueryResolver;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.logging.Log4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Log4j
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

    public List<FoodDTO> getAllFoods(String code) {
     /*    Log.info("CODE: " + code.toString());
       Log.info("CODE: " + code.toString());

*/

        var foods = converter.foodToDto(foodService.getAllFoods());

        if (code == null || code.isEmpty()) {
            return foods;
        }
        System.out.println("CODE: " + code.toString());
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        shell.setVariable("foods", foods);

        var data = shell.evaluate(code);
        return (List<FoodDTO>) data;


    }


    public FoodDTO getFoodByID(Long id) {
        return converter.foodToDto(foodService.getByID(id));
    }

}
