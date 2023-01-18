package com.naoInternet.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "recepcionInventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecepcionInventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionInventario;

    @Column(name = "factura", nullable = false)
    private Long factura;

    @Column(name = "fechaEntrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Column(name = "fechaFactura", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;

    @Column(name = "recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;

    @ManyToOne
    @JoinColumn(name="proveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="ordenCompra", nullable = false)
    private OrdenCompra ordenCompra;

}
