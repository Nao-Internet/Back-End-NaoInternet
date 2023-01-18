package com.naoInternet.Repository;

import com.naoInternet.Entity.SalidaInventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISalidaInventarioRepository  extends JpaRepository<SalidaInventario, Long> {

    public SalidaInventario findByCodigoSalida(Long codigoSalida);

    public List<SalidaInventario> findByPartidaDestino(String partidaDestino);

    public List<SalidaInventario> findByAreaDestino(String areaDestino);

}
