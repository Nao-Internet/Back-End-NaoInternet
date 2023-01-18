package com.naoInternet.Service;

import com.naoInternet.Entity.SalidaInventario;

import java.util.List;

public interface ISalidaInventarioService extends CrudService<SalidaInventario> {

    public SalidaInventario findByCodigoSalida(Long codigoSalida) throws Exception;

    public List<SalidaInventario> findByPartidaDestino(String partidaDestino)throws Exception;

    public List<SalidaInventario> findByAreaDestino(String areaDestino)throws Exception;
}
