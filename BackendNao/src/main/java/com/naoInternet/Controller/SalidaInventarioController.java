package com.naoInternet.Controller;


import com.naoInternet.Entity.SalidaInventario;
import com.naoInternet.Service.ISalidaInventarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/salidaInventario")
@Api(tags = "SalidaInventario", value = "Service Web RESTFul de SalidaInventario")
public class SalidaInventarioController {

    @Autowired
    private ISalidaInventarioService salidaInventarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar SalidaInventario",notes = "Métodos para listar a todas las SalidaInventario")
    @ApiResponses({
            @ApiResponse(code = 201, message = "SalidaInventario encontrados"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrados")
    })
    public ResponseEntity<List<SalidaInventario>> findAll(){
        try {
            List<SalidaInventario> salidaInventarios = salidaInventarioService.getAll();
            //if (salidaInventarios.size() > 0)
            return new ResponseEntity<List<SalidaInventario>>(salidaInventarios, HttpStatus.OK);
            //else
            // return new ResponseEntity<List<SalidaInventario>>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            return new ResponseEntity<List<SalidaInventario>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de SalidaInventario", notes = "Método que registra SalidaInventario en BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "SalidaInventario creado"),
            @ApiResponse(code = 404, message = "SalidaInventario no creado")
    })
    public ResponseEntity<SalidaInventario> insertSalidaInventario(@Valid @RequestBody SalidaInventario salidaInventario) {
        try {
            SalidaInventario salidaInventarioNew = salidaInventarioService.save(salidaInventario);
            return ResponseEntity.status(HttpStatus.CREATED).body(salidaInventarioNew);
        } catch (Exception e) {
            return new ResponseEntity<SalidaInventario>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualización de datos de SalidaInventario", notes = "Metodo que actualiza los datos de SalidaInventario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de SalidaInventario actualizados"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrado")
    })
    public ResponseEntity<SalidaInventario> updateSalidaInventario(
            @PathVariable("id") Long id, @Valid @RequestBody SalidaInventario salidaInventario) {
        try {
            Optional<SalidaInventario> salidaInventarioUp = salidaInventarioService.getById(id);
            if (!salidaInventarioUp.isPresent())
                return new ResponseEntity<SalidaInventario>(HttpStatus.NOT_FOUND);
            salidaInventario.setIdSalidaInventario(id);
            salidaInventarioService.save(salidaInventario);
            return new ResponseEntity<SalidaInventario>(salidaInventario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<SalidaInventario>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Eliminación de SalidaInventario", notes = "Metodo que elimina los datos de SalidaInventario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de SalidaInventario eliminados"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrado")
    })
    public ResponseEntity<SalidaInventario> deleteSalidaInventario(@PathVariable("id") Long id) {
        try {
            Optional<SalidaInventario> salidaInventarioDelete = salidaInventarioService.getById(id);
            if (!salidaInventarioDelete.isPresent())
                return new ResponseEntity<SalidaInventario>(HttpStatus.NOT_FOUND);
            salidaInventarioService.delete(id);
            return new ResponseEntity<SalidaInventario>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SalidaInventario>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar SalidaInventario por Id", notes = "Métodos para encontrar un SalidaInventario por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "SalidaInventario encontrado"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrado")
    })
    public ResponseEntity<SalidaInventario> findById(@PathVariable("id") Long id) {
        try {
            Optional<SalidaInventario> salidaInventarioOptional = salidaInventarioService.getById(id);
            if (!salidaInventarioOptional.isPresent())
                return new ResponseEntity<SalidaInventario>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<SalidaInventario>(salidaInventarioOptional.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SalidaInventario>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByCodigoSalida/{codigoSalida}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar SalidaInventario por codigoSalida", notes = "Métodos para encontrar una SalidaInventario por su respectivo codigoSalida")
    @ApiResponses({
            @ApiResponse(code = 201, message = "SalidaInventario encontrado"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrado")
    })
    public ResponseEntity<SalidaInventario> findByCodigoSalida(@PathVariable("codigoSalida") Long codigoSalida) {
        try {
            SalidaInventario salidaInventario = salidaInventarioService.findByCodigoSalida(codigoSalida);
            if (salidaInventario == null)
                return new ResponseEntity<SalidaInventario>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<SalidaInventario>(salidaInventario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<SalidaInventario>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("searchByPartidaDestino/{partidaDestino}")
    @ApiOperation(value = "Buscar SalidaInventario por partidaDestino", notes = "Métodos para encontrar un Personal por su respectivo partidaDestino")
    @ApiResponses({
            @ApiResponse(code = 201, message = "SalidaInventario encontrados"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrados")
    })
    public ResponseEntity<List<SalidaInventario>> findByPartidaDestino(@PathVariable("partidaDestino") String partidaDestino) {
        try {
            List<SalidaInventario> salidaInventarios = salidaInventarioService.findByPartidaDestino(partidaDestino);
            if (salidaInventarios.size() > 0)
                return new ResponseEntity<List<SalidaInventario>>(salidaInventarios, HttpStatus.OK);
            else
                return new ResponseEntity<List<SalidaInventario>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<SalidaInventario>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("searchByAreaDestino/{areaDestino}")
    @ApiOperation(value = "Buscar SalidaInventario por areaDestino", notes = "Métodos para encontrar un Personal por su respectivo areaDestino")
    @ApiResponses({
            @ApiResponse(code = 201, message = "SalidaInventario encontrados"),
            @ApiResponse(code = 404, message = "SalidaInventario no encontrados")
    })
    public ResponseEntity<List<SalidaInventario>> findByAreaDestino(@PathVariable("areaDestino") String areaDestino) {
        try {
            List<SalidaInventario> salidaInventarios = salidaInventarioService.findByAreaDestino(areaDestino);
            if (salidaInventarios.size() > 0)
                return new ResponseEntity<List<SalidaInventario>>(salidaInventarios, HttpStatus.OK);
            else
                return new ResponseEntity<List<SalidaInventario>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<SalidaInventario>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
