package com.naoInternet.Service;

import com.naoInternet.Entity.Country;

import java.util.List;

public interface ICountryService extends CrudService<Country>{
    public List<Country> findByCountryName(String name)throws Exception;

}
