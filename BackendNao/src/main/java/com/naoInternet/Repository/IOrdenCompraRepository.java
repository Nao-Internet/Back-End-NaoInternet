package com.naoInternet.Repository;

import com.naoInternet.Entity.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    public OrdenCompra findByNumeroOrden(Long numeroOrden);

    public List<OrdenCompra> findByFormaPago(String formaPago);
}
