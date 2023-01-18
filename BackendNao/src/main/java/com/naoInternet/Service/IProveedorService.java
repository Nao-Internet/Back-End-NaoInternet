package com.naoInternet.Service;

import com.naoInternet.Entity.Proveedor;

import java.util.List;

public interface IProveedorService extends CrudService<Proveedor> {

    public Proveedor findByRuc(Long ruc) throws Exception;

    public List<Proveedor> findByNombresProveedor(String nombres) throws Exception;

    public List<Proveedor> findByRazonSocial(String razonSocial) throws Exception;
}
