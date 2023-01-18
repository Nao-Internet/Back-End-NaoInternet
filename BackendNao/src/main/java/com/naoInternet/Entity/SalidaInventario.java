package com.naoInternet.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "salidadInventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalidaInventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalidaInventario;

    @Column(name = "codigoSalida", nullable = false)
    private Long codigoSalida;


    @Column(name = "fechaSalida", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    @Column(name = "partidaDestino", nullable = false)
    private String partidaDestino;

    @Column(name = "areaDestino", nullable = false)
    private String areaDestino;

    @Column(name = "tipoSalida", nullable = false)
    private String tipoSalida;

    @ManyToOne
    @JoinColumn (name = "id_personal", nullable = false)
    private Personal personal;

}
