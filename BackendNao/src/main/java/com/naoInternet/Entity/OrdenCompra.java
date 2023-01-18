package com.naoInternet.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "ordenCompra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdenCompra;


    @Column(name = "numeroOrden", nullable = false)
    private Long numeroOrden;

    @Column(name = "fechaOrden", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;

    @Column(name = "partidaDestino", nullable = false)
    private String partidaDestino;

    @Column(name = "areaDestino", nullable = false)
    private String areaDestino;

    @Column(name = "plazoPago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plazoPago;

    @Column(name = "fechaEntrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Column(name = "condicionesEnvio", nullable = true)
    private String condicionesEnvio;

    @Column(name = "formaPago", nullable = false)
    private String formaPago;

    @Column(name = "importancia", nullable = false)
    private String importancia;

    @Column(name = "enbarcarVia", nullable = false)
    private String enbarcarVia;

    @Column(name = "requerizar", nullable = true)
    private String requerizar;

    @Column(name = "fob", nullable = true)
    private String fob;

    @Column(name = "nombreReceptor", nullable = false)
    private String nombreReceptor;

    @Column(name = "empresaEnvio", nullable = false)
    private String empresaEnvio;

    @Column(name = "direccionEnvio", nullable = false)
    private String direccionEnvio;

    @Column(name = "ciudadEnvio", nullable = false)
    private String ciudadEnvio;

    @Column(name = "telefono", nullable = false)
    private Long telefono;

    @Column(name = "comentarios", nullable = false)
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_personal", nullable = false)
    private Personal personal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
}
