package com.example.graphqlexample;

import com.example.graphqlexample.model.Category;
import com.example.graphqlexample.model.Food;
import com.example.graphqlexample.repository.CategoryRepository;
import com.example.graphqlexample.service.CategoryService;
import com.example.graphqlexample.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GraphqlexampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlexampleApplication.class, args);
    }

    @Autowired
    CategoryService categoryService;

    @Autowired
    FoodService foodService;

    @Override
    public void run(String... args) throws Exception {
        categoryService.create(Category.builder().name("Dishes").build());
        categoryService.create(Category.builder().name("Turkish Foods").build());
        categoryService.create(Category.builder().name("Mexican Foods").build());
        categoryService.create(Category.builder().name("Fishes").build());
        categoryService.create(Category.builder().name("Soups").build());
        categoryService.create(Category.builder().name("Deserts").build());

        foodService.create(Food.builder().name("Cake").recipe("cake recipe").categories(List.of(Category.builder().id(6L).build())).build());
        foodService.create(Food.builder().name("Kelle paca").recipe("soup recipe").categories(
                List.of(Category.builder().id(2L).build(),
                Category.builder().id(5L).build())).build());
        foodService.create(Food.builder().name("Lahmacun").recipe("lahmacun recipe").categories(List.of(Category.builder().id(2L).build())).build());
        foodService.create(Food.builder().name("Kebab").recipe("kebab").categories(List.of(Category.builder().id(2L).build())).build());
    }
}
