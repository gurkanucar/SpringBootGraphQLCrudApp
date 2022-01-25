package com.example.graphqlexample.dto.converter;

import com.example.graphqlexample.dto.CategoryDTO;
import com.example.graphqlexample.dto.CategoryInsideFoodDTO;
import com.example.graphqlexample.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryInsideFoodConverter {

   public Category dtoToCategory(CategoryInsideFoodDTO categoryDTO) {
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

    public CategoryInsideFoodDTO categoryToDto(Category category) {
        return CategoryInsideFoodDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public List<CategoryInsideFoodDTO> categoryToDto(List<Category> categories){
        return categories.stream()
                .map(this::categoryToDto).collect(Collectors.toList());
    }

    public List<Category> dtoToCategory(List<CategoryInsideFoodDTO> categories){
        return categories.stream()
                .map(this::dtoToCategory).collect(Collectors.toList());
    }

}
