package com.naoInternet.Service.impl;


import com.naoInternet.Entity.SalidaInventario;
import com.naoInternet.Repository.ISalidaInventarioRepository;
import com.naoInternet.Service.ISalidaInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SalidaInventarioServiceImpl implements ISalidaInventarioService {

    @Autowired
    private ISalidaInventarioRepository salidaInventarioRepository;

    @Override
    @Transactional
    public SalidaInventario save(SalidaInventario salidaInventario) throws Exception {
        return salidaInventarioRepository.save(salidaInventario);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        salidaInventarioRepository.deleteById(id);
    }

    @Override
    public List<SalidaInventario> getAll() throws Exception {
        return salidaInventarioRepository.findAll();
    }

    @Override
    public Optional<SalidaInventario> getById(Long id) throws Exception {
        return salidaInventarioRepository.findById(id);
    }

    @Override
    public SalidaInventario findByCodigoSalida(Long codigoSalida) throws Exception {
        return salidaInventarioRepository.findByCodigoSalida(codigoSalida);
    }

    @Override
    public List<SalidaInventario> findByPartidaDestino(String partidaDestino) throws Exception {
        return salidaInventarioRepository.findByPartidaDestino(partidaDestino);
    }

    @Override
    public List<SalidaInventario> findByAreaDestino(String areaDestino) throws Exception {
        return salidaInventarioRepository.findByAreaDestino(areaDestino);
    }
}
