package com.naoInternet.Repository;

import com.naoInternet.Entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {

    public Proveedor findByRuc(Long ruc);

    public List<Proveedor> findByNombresProveedor(String nombresProveedor);

    public List<Proveedor> findByRazonSocial(String razonSocial);
}
