package com.naoInternet.Service;

import com.naoInternet.Entity.RecipeIngredient;

import java.util.List;

public interface IRecipeIngredientService extends CrudService<RecipeIngredient>{
    public List<RecipeIngredient> findByQuantity(Integer quantity)throws Exception;
}
