package com.naoInternet.Service.impl;

import com.naoInternet.Entity.OrdenCompra;
import com.naoInternet.Repository.IOrdenCompraRepository;
import com.naoInternet.Service.IOrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrdenCompraServiceImpl implements IOrdenCompraService {

    @Autowired
    private IOrdenCompraRepository ordenCompraRepository;

    @Override
    @Transactional
    public OrdenCompra save(OrdenCompra ordenCompra) throws Exception {
        return ordenCompraRepository.save(ordenCompra);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        ordenCompraRepository.deleteById(id);
    }

    @Override
    public List<OrdenCompra> getAll() throws Exception {
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<OrdenCompra> getById(Long id) throws Exception {
        return ordenCompraRepository.findById(id);
    }

    @Override
    public OrdenCompra findByNumeroOrden(Long numeroOrden) throws Exception {
        return ordenCompraRepository.findByNumeroOrden(numeroOrden);
    }

    @Override
    public List<OrdenCompra> findByFormaPago(String formaPago) throws Exception {
        return ordenCompraRepository.findByFormaPago(formaPago);
    }
}
