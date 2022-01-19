package com.example.graphqlexample.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String recipe;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;


}
