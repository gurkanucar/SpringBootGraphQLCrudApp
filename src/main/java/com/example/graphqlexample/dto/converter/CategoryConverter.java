package com.example.graphqlexample.dto.converter;

import com.example.graphqlexample.dto.CategoryDTO;
import com.example.graphqlexample.dto.FoodDTO;
import com.example.graphqlexample.model.Category;
import com.example.graphqlexample.model.Food;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

   public Category dtoToCategory(CategoryDTO categoryDTO) {
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

    public CategoryDTO categoryToDto(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public List<CategoryDTO> categoryToDto(List<Category> categories){
        return categories.stream()
                .map(x->categoryToDto(x)).collect(Collectors.toList());
    }


}
