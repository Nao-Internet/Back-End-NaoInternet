package com.naoInternet.Service.impl;


import com.naoInternet.Entity.Personal;
import com.naoInternet.Repository.IPersonalRepository;
import com.naoInternet.Service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class PersonalServiceImpl implements IPersonalService {

    @Autowired
    private IPersonalRepository personalRepository;

    @Override
    @Transactional
    public Personal save(Personal personal) throws Exception {
        return personalRepository.save(personal);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        personalRepository.deleteById(id);

    }

    @Override
    public List<Personal> getAll() throws Exception {
        return personalRepository.findAll();
    }

    @Override
    public Optional<Personal> getById(Long id) throws Exception {
        return personalRepository.findById(id);
    }

    @Override
    public Personal findByDni(Long dni) throws Exception {
        return personalRepository.findByDni(dni);
    }

    @Override
    public List<Personal> findByNombres(String nombres) throws Exception {
        return personalRepository.findByNombres(nombres);
    }

    @Override
    public List<Personal> findByApellidos(String apellidos) throws Exception {
        return personalRepository.findByApellidos(apellidos);
    }
}
