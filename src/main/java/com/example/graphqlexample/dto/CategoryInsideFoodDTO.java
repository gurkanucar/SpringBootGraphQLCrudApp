package com.example.graphqlexample.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryInsideFoodDTO {

    private Long id;
    @NotNull
    private String name;

}
