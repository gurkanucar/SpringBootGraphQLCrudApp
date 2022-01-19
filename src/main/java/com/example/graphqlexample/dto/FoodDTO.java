package com.example.graphqlexample.dto;

import com.example.graphqlexample.model.Category;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private Long id;
    private String name;
    private String recipe;
    private List<Category> categories;

}
