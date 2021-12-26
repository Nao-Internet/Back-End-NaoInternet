package com.naoInternet.Service.impl;

import com.naoInternet.Entity.Chef;
import com.naoInternet.Repository.IChefRepository;
import com.naoInternet.Service.IChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ChefServiceImpl implements IChefService {

    @Autowired
    private IChefRepository chefRepository;

    @Override
    @Transactional
    public Chef save(Chef chef) throws Exception {
        return chefRepository.save(chef);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        chefRepository.deleteById(id);
    }

    @Override
    public List<Chef> getAll() throws Exception {
        return chefRepository.findAll();
    }

    @Override
    public Optional<Chef> getById(Long id) throws Exception {
        return chefRepository.findById(id);
    }

    @Override
    public Chef findByDni(String dni) throws Exception {
        return chefRepository.findByDni(dni);
    }

    @Override
    public List<Chef> findByLastName(String lastname) throws Exception {
        return chefRepository.findByLastName(lastname);
    }

    @Override
    public List<Chef> findByFirstName(String firstname) throws Exception {
        return chefRepository.findByFirstName((firstname));
    }

    @Override
    public List<Chef> findByFirstNameAndLastName(String firstname, String lastname) throws Exception {
        return chefRepository.findByFirstNameAndLastName(firstname,lastname);
    }
}
