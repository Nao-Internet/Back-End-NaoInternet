package com.naoInternet.Service;

import com.naoInternet.Entity.Recipe;

import java.util.Date;
import java.util.List;

public interface IRecipeService extends CrudService<Recipe> {
    public List<Recipe> find(Date publication_date) throws Exception;

}
