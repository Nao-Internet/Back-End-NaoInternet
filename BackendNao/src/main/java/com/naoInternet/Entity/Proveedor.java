package com.naoInternet.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Proveedor.findByNombresProveedor",query = "select b from Proveedor b where b.nombresProveedor=?1")
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @Column(name = "tipoProveedor", nullable = false, length = 20)
    private String tipoProveedor;

    @Column(name = "nombresProveedor", nullable = false, length = 30)
    private String nombresProveedor;

    @Column(name = "apellidosProveedor", nullable = false, length = 30)
    private String apellidosProveedor;

    @Column(name = "telefonoProveedor", nullable = false)
    private Long telefonoProveedor;

    @Column(name = "telefonoOpcional", nullable = true)
    private Long telefonoOpcional;

    @Column(name = "telefonoSecundario", nullable = true)
    private Long telefonoSecundario;

    @Column(name = "razonSocial", nullable = false)
    private String razonSocial;

    @Column(name = "ruc", nullable = false)
    private Long ruc;

    @Column(name = "direccionProveedor", nullable = false, length = 50 )
    private String direccionProveedor;

    @Column(name = "paisProveedor", nullable = false, length = 20)
    private String paisProveedor;

    @Column(name = "regionProveedor", nullable = false, length = 20)
    private String regionProveedor;

    @Column(name = "correoProveedor", nullable = false, length = 30)
    private String correoProveedor;
}
