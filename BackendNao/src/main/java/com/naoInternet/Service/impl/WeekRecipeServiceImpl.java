package com.naoInternet.Service.impl;

import com.naoInternet.Entity.WeekRecipe;
import com.naoInternet.Repository.IWeekRecipeRepository;
import com.naoInternet.Service.IWeekRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class WeekRecipeServiceImpl implements IWeekRecipeService {

    @Autowired
    private IWeekRecipeRepository weekRecipeRepository;

    @Override
    public WeekRecipe save(WeekRecipe weekRecipe) throws Exception {
        return weekRecipeRepository.save(weekRecipe);
    }

    @Override
    public void delete(Long id) throws Exception {
        weekRecipeRepository.deleteById(id);
    }

    @Override
    public List<WeekRecipe> getAll() throws Exception {
        return weekRecipeRepository.findAll();
    }

    @Override
    public Optional<WeekRecipe> getById(Long id) throws Exception {
        return weekRecipeRepository.findById(id);
    }

    @Override
    public List<WeekRecipe> find(Date added_date) throws Exception {
        return weekRecipeRepository.find(added_date);
    }

}
