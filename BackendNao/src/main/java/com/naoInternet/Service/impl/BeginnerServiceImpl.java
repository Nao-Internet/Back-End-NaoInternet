package com.naoInternet.Service.impl;

import com.naoInternet.Entity.Beginner;
import com.naoInternet.Repository.IBeginnerRepository;
import com.naoInternet.Service.IBeginnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BeginnerServiceImpl implements IBeginnerService {

    @Autowired
    private IBeginnerRepository beginnerRepository;

    @Override
    @Transactional
    public Beginner save(Beginner beginner) throws Exception {
        return beginnerRepository.save(beginner);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        beginnerRepository.deleteById(id);
    }

    @Override
    public List<Beginner> getAll() throws Exception {
        return beginnerRepository.findAll();
    }

    @Override
    public Optional<Beginner> getById(Long id) throws Exception {
        return beginnerRepository.findById(id);
    }

    @Override
    public Beginner findByDni(String dni) throws Exception {
        return beginnerRepository.findByDni(dni);
    }

    @Override
    public List<Beginner> findByLastName(String lastname) throws Exception {
        return beginnerRepository.findByLastName(lastname);
    }

    @Override
    public List<Beginner> findByFirstName(String firstname) throws Exception {
        return beginnerRepository.findByFirstName((firstname));
    }

    @Override
    public List<Beginner> findByFirstNameAndLastName(String firstname, String lastname) throws Exception {
        return beginnerRepository.findByFirstNameAndLastName(firstname,lastname);
    }
}
