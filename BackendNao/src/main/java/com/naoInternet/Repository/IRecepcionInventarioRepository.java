package com.naoInternet.Repository;

import com.naoInternet.Entity.Proveedor;
import com.naoInternet.Entity.RecepcionInventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRecepcionInventarioRepository extends JpaRepository<RecepcionInventario, Long> {

    public RecepcionInventario findByFactura(Long factura);

    public List<RecepcionInventario> findByProveedor(Proveedor proveedor);
}
