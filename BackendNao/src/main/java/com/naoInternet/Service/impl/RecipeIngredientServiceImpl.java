package com.naoInternet.Service.impl;

import com.naoInternet.Entity.RecipeIngredient;
import com.naoInternet.Repository.IRecipeIngredientRepository;
import com.naoInternet.Service.IRecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RecipeIngredientServiceImpl implements IRecipeIngredientService {

    @Autowired
    private IRecipeIngredientRepository recipeIngredientRepository;

    @Override
    @Transactional
    public RecipeIngredient save(RecipeIngredient recipeIngredient) throws Exception {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public void delete(Long id) throws Exception {
        recipeIngredientRepository.deleteById(id);
    }

    @Override
    public List<RecipeIngredient> getAll() throws Exception {
        return recipeIngredientRepository.findAll();
    }

    @Override
    public Optional<RecipeIngredient> getById(Long id) throws Exception {
        return recipeIngredientRepository.findById(id);
    }

    @Override
    public List<RecipeIngredient> findByQuantity(Integer quantity) throws Exception {
        return recipeIngredientRepository.findByQuantity(quantity);
    }

}
