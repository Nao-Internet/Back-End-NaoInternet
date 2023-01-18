package com.naoInternet.Service.impl;


import com.naoInternet.Entity.Proveedor;
import com.naoInternet.Repository.IProveedorRepository;
import com.naoInternet.Service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    @Transactional
    public Proveedor save(Proveedor proveedor) throws Exception {
        return proveedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        proveedorRepository.deleteById(id);
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> getById(Long id) throws Exception {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor findByRuc(Long ruc) throws Exception {
        return proveedorRepository.findByRuc(ruc);
    }

    @Override
    public List<Proveedor> findByNombresProveedor(String nombres) throws Exception {
        return proveedorRepository.findByNombresProveedor(nombres);
    }

    @Override
    public List<Proveedor> findByRazonSocial(String razonSocial) throws Exception {
        return proveedorRepository.findByRazonSocial(razonSocial);
    }
}
