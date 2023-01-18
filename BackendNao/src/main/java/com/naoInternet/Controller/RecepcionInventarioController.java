package com.naoInternet.Controller;

import com.naoInternet.Entity.Proveedor;
import com.naoInternet.Entity.RecepcionInventario;
import com.naoInternet.Entity.SalidaInventario;
import com.naoInternet.Service.IRecepcionInventarioService;
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
@RequestMapping("/api/recepcionInventario")
@Api(tags = "RecepcionInventario", value = "Service Web RESTful de RecepcionInventario")
public class RecepcionInventarioController {

    @Autowired
    private IRecepcionInventarioService recepcionInventarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar RecepcionInventario",notes = "Métodos para listar a todas las RecepcionInventarios")
    @ApiResponses({
            @ApiResponse(code = 201, message = "RecepcionInventario encontrados"),
            @ApiResponse(code = 404, message = "RecepcionInventario no encontrados")
    })
    public ResponseEntity<List<RecepcionInventario>> findAll(){
        try {
            List<RecepcionInventario> recepcionInventarios = recepcionInventarioService.getAll();
            //if (recepcionInventarios.size() > 0)
            return new ResponseEntity<List<RecepcionInventario>>(recepcionInventarios, HttpStatus.OK);
            //else
            // return new ResponseEntity<List<RecepcionInventario>>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            return new ResponseEntity<List<RecepcionInventario>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de RecepcionInventario", notes = "Método que registra RecepcionInventario en BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "RecepcionInventario creado"),
            @ApiResponse(code = 404, message = "RecepcionInventario no creado")
    })
    public ResponseEntity<RecepcionInventario> insertRecepcionInventario(@Valid @RequestBody RecepcionInventario recepcionInventario) {
        try {
            RecepcionInventario recepcionInventarioNew = recepcionInventarioService.save(recepcionInventario);
            return ResponseEntity.status(HttpStatus.CREATED).body(recepcionInventarioNew);
        } catch (Exception e) {
            return new ResponseEntity<RecepcionInventario>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualización de datos de RecepcionInventario", notes = "Metodo que actualiza los datos de RecepcionInventario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de RecepcionInventario actualizados"),
            @ApiResponse(code = 404, message = "RecepcionInventario no encontrado")
    })
    public ResponseEntity<RecepcionInventario> updateRecepcionInventario(
            @PathVariable("id") Long id, @Valid @RequestBody RecepcionInventario recepcionInventario) {
        try {
            Optional<RecepcionInventario> recepcionInventarioUp = recepcionInventarioService.getById(id);
            if (!recepcionInventarioUp.isPresent())
                return new ResponseEntity<RecepcionInventario>(HttpStatus.NOT_FOUND);
            recepcionInventario.setIdRecepcionInventario(id);
            recepcionInventarioService.save(recepcionInventario);
            return new ResponseEntity<RecepcionInventario>(recepcionInventario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<RecepcionInventario>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Eliminación de RecepcionInventario", notes = "Metodo que elimina los datos de RecepcionInventario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de RecepcionInventario eliminados"),
            @ApiResponse(code = 404, message = "RecepcionInventario no encontrado")
    })
    public ResponseEntity<RecepcionInventario> deleteRecepcionInventario(@PathVariable("id") Long id) {
        try {
            Optional<RecepcionInventario> recepcionInventarioDelete = recepcionInventarioService.getById(id);
            if (!recepcionInventarioDelete.isPresent())
                return new ResponseEntity<RecepcionInventario>(HttpStatus.NOT_FOUND);
            recepcionInventarioService.delete(id);
            return new ResponseEntity<RecepcionInventario>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<RecepcionInventario>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar RecepcionInventario por Id", notes = "Métodos para encontrar un RecepcionInventario por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "RecepcionInventario encontrado"),
            @ApiResponse(code = 404, message = "RecepcionInventario no encontrado")
    })
    public ResponseEntity<RecepcionInventario> findById(@PathVariable("id") Long id) {
        try {
            Optional<RecepcionInventario> recepcionInventarioOptional = recepcionInventarioService.getById(id);
            if (!recepcionInventarioOptional.isPresent())
                return new ResponseEntity<RecepcionInventario>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<RecepcionInventario>(recepcionInventarioOptional.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<RecepcionInventario>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByFactura/{factura}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar RecepcionInventario por factura", notes = "Métodos para encontrar una RecepcionInventario por su respectiva factura")
    @ApiResponses({
            @ApiResponse(code = 201, message = "RecepcionInventario encontrado"),
            @ApiResponse(code = 404, message = "RecepcionInventario no encontrado")
    })
    public ResponseEntity<RecepcionInventario> findByFactura(@PathVariable("factura") Long factura) {
        try {
            RecepcionInventario recepcionInventario = recepcionInventarioService.findByFactura(factura);
            if (recepcionInventario == null)
                return new ResponseEntity<RecepcionInventario>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<RecepcionInventario>(recepcionInventario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<RecepcionInventario>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("searchByProveedor/{proveedor}")
    @ApiOperation(value = "Buscar RecepcionInventario por proveedor", notes = "Métodos para encontrar un RecepcionInventario por su respectivo proveedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "RecepcionInventario encontrados"),
            @ApiResponse(code = 404, message = "RecepcionInventario no encontrados")
    })
    public ResponseEntity<List<RecepcionInventario>> findByProveedor(@PathVariable("proveedor") Proveedor proveedor) {
        try {
            List<RecepcionInventario> recepcionInventarios = recepcionInventarioService.findByProveedor(proveedor);
            if (recepcionInventarios.size() > 0)
                return new ResponseEntity<List<RecepcionInventario>>(recepcionInventarios, HttpStatus.OK);
            else
                return new ResponseEntity<List<RecepcionInventario>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<RecepcionInventario>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
