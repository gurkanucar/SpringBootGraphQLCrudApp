package com.example.graphqlexample.resolver.category;

import com.example.graphqlexample.dto.CategoryDTO;
import com.example.graphqlexample.dto.converter.CategoryConverter;
import com.example.graphqlexample.model.Category;
import com.example.graphqlexample.service.CategoryService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class CategoryMutationResolver implements GraphQLMutationResolver {

    private final CategoryService categoryService;
    private final CategoryConverter converter;

    public CategoryMutationResolver(CategoryService categoryService,
                                    CategoryConverter converter) {
        this.categoryService = categoryService;
        this.converter = converter;
    }


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = converter.dtoToCategory(categoryDTO);
        return converter.categoryToDto(categoryService.create(category));
    }


}
