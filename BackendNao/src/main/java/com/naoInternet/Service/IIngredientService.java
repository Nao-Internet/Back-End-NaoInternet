package com.naoInternet.Service;

import com.naoInternet.Entity.Ingredient;

import java.util.List;

public interface IIngredientService extends CrudService<Ingredient>{
    public List<Ingredient> findByName(String name)throws Exception;
}
