package com.naoInternet.Service;


import com.naoInternet.Entity.WeekRecipe;

import java.util.Date;
import java.util.List;

public interface IWeekRecipeService extends CrudService<WeekRecipe>{

    public List<WeekRecipe> find(Date added_date) throws Exception;


}
