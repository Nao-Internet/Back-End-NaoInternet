package com.naoInternet.Service.impl;

import com.naoInternet.Entity.Proveedor;
import com.naoInternet.Entity.RecepcionInventario;
import com.naoInternet.Repository.IRecepcionInventarioRepository;
import com.naoInternet.Service.IRecepcionInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RecepcionInventarioImpl implements IRecepcionInventarioService {
    @Autowired
    private IRecepcionInventarioRepository recepcionInventarioRepository;

    @Override
    public RecepcionInventario save(RecepcionInventario recepcionInventario) throws Exception {
        return recepcionInventarioRepository.save(recepcionInventario);
    }

    @Override
    public void delete(Long id) throws Exception {
        recepcionInventarioRepository.deleteById(id);
    }

    @Override
    public List<RecepcionInventario> getAll() throws Exception {
        return recepcionInventarioRepository.findAll();
    }

    @Override
    public Optional<RecepcionInventario> getById(Long id) throws Exception {
        return recepcionInventarioRepository.findById(id);
    }

    @Override
    public RecepcionInventario findByFactura(Long factura) throws Exception {
        return recepcionInventarioRepository.findByFactura(factura);
    }

    @Override
    public List<RecepcionInventario> findByProveedor(Proveedor proveedor) throws Exception {
        return recepcionInventarioRepository.findByProveedor(proveedor);
    }
}
