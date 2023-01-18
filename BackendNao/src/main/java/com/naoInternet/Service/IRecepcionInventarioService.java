package com.naoInternet.Service;

import com.naoInternet.Entity.Proveedor;
import com.naoInternet.Entity.RecepcionInventario;

import java.util.List;

public interface IRecepcionInventarioService extends CrudService<RecepcionInventario> {
    public RecepcionInventario findByFactura(Long factura) throws Exception;

    public List<RecepcionInventario> findByProveedor(Proveedor proveedor) throws Exception;
}
