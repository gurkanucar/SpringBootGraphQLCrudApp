package com.example.graphqlexample.resolver.category;

import com.example.graphqlexample.dto.CategoryDTO;
import com.example.graphqlexample.dto.converter.CategoryConverter;
import com.example.graphqlexample.service.CategoryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryQueryResolver implements GraphQLQueryResolver {

    private final CategoryService categoryService;
    private final CategoryConverter converter;

    public CategoryQueryResolver(CategoryService categoryService, CategoryConverter converter) {
        this.categoryService = categoryService;
        this.converter = converter;
    }

    public List<CategoryDTO> getAllCategories() {
        return converter.categoryToDto(categoryService.getAllCategories());
    }

}
