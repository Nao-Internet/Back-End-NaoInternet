package com.naoInternet.Service.impl;

import com.naoInternet.Entity.Recipe;
import com.naoInternet.Repository.IRecipeRepository;
import com.naoInternet.Service.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServiceImpl implements IRecipeService {

    @Autowired
    private IRecipeRepository recipeRepository;

    @Override
    @Transactional
    public Recipe save(Recipe recipe) throws Exception {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Long id) throws Exception {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<Recipe> getAll() throws Exception {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getById(Long id) throws Exception {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> find(Date publication_date) throws Exception {
        return recipeRepository.find(publication_date);
    }
}
