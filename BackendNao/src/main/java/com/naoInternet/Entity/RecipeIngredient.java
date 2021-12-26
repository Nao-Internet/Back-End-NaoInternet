package com.naoInternet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RecipeIngredient implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity",nullable = false,length = 50)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Recipe recipe;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ingredient ingredient;*/


}
