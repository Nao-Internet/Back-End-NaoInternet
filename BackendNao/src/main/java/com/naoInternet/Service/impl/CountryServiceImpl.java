package com.naoInternet.Service.impl;

import com.naoInternet.Entity.Country;
import com.naoInternet.Repository.ICountryRepository;
import com.naoInternet.Service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Country save(Country country) throws Exception {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Long id) throws Exception {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> getAll() throws Exception {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getById(Long id) throws Exception {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findByCountryName(String name) throws Exception {
        return countryRepository.findByCountryName(name);
    }
}
