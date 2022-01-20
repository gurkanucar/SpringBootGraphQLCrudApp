package com.example.graphqlexample.dto;

import com.example.graphqlexample.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String recipe;
    @NotNull
    private List<Category> categories;

}
