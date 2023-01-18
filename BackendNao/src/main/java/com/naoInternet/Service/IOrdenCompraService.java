package com.naoInternet.Service;

import com.naoInternet.Entity.OrdenCompra;

import java.util.List;

public interface IOrdenCompraService extends CrudService<OrdenCompra> {

    public OrdenCompra findByNumeroOrden(Long numeroOrden) throws Exception;

    public List<OrdenCompra> findByFormaPago(String formaPago) throws Exception;
}
