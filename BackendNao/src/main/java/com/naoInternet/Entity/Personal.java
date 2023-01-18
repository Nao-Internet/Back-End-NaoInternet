package com.naoInternet.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "personal")
@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedQuery(name = "Personal.findByNombres",query = "select b from Personal b where b.nombres=?1")
public class Personal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonal;

    @NotNull
    @NotBlank(message = "Los nombres son obligatorios")
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;


    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "dni", nullable = false)
    private Long dni;

    @Column(name = "cargo", nullable = false, length = 20)
    private String cargo;

    @Column(name = "turno", nullable = false, length = 10)
    private String turno;

    @Column(name = "asignado", nullable = false, length = 15)
    private String asignado;

    @Column(name = "telefono", nullable = false)
    private Long telefono;

    @Column(name = "pertenece", nullable = false, length = 20)
    private String pertenece;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @Column(name = "fechaIncorporacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIncorporacion;
}
