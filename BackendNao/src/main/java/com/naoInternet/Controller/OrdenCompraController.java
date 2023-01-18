package com.naoInternet.Controller;


import com.naoInternet.Entity.OrdenCompra;
import com.naoInternet.Service.IOrdenCompraService;
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
@RequestMapping("/api/ordenCompra")
@Api(tags = "OrdenCompra", value = "Service Web RESTFul de Personal")
public class OrdenCompraController {

    @Autowired
    private IOrdenCompraService ordenCompraService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar Ordenes de compra",notes = "Métodos para listar a todas las Ordenes de compra")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Orden de Compra encontrados"),
            @ApiResponse(code = 404, message = "Orden de Compra no encontrados")
    })
    public ResponseEntity<List<OrdenCompra>> findAll(){
        try {
            List<OrdenCompra> ordenCompras = ordenCompraService.getAll();
            //if (ordenCompras.size() > 0)
            return new ResponseEntity<List<OrdenCompra>>(ordenCompras, HttpStatus.OK);
            //else
            // return new ResponseEntity<List<OrdenCompra>>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            return new ResponseEntity<List<OrdenCompra>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Ordenes de Compra", notes = "Método que registra Ordenes de Compra en BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Orden de Compra creado"),
            @ApiResponse(code = 404, message = "Orden de Compra no creado")
    })
    public ResponseEntity<OrdenCompra> insertOrdenCompra(@Valid @RequestBody OrdenCompra ordenCompra) {
        try {
            OrdenCompra ordenCompraNew = ordenCompraService.save(ordenCompra);
            return ResponseEntity.status(HttpStatus.CREATED).body(ordenCompraNew);
        } catch (Exception e) {
            return new ResponseEntity<OrdenCompra>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualización de datos de OrdenCompra", notes = "Metodo que actualiza los datos de OrdenCompra")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OrdenCompra actualizados"),
            @ApiResponse(code = 404, message = "OrdenCompra no encontrado")
    })
    public ResponseEntity<OrdenCompra> updateOrdenCompra(
            @PathVariable("id") Long id, @Valid @RequestBody OrdenCompra ordenCompra) {
        try {
            Optional<OrdenCompra> ordenCompraUp = ordenCompraService.getById(id);
            if (!ordenCompraUp.isPresent())
                return new ResponseEntity<OrdenCompra>(HttpStatus.NOT_FOUND);
            ordenCompra.setIdOrdenCompra(id);
            ordenCompraService.save(ordenCompra);
            return new ResponseEntity<OrdenCompra>(ordenCompra, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<OrdenCompra>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Eliminación de OrdenCompra", notes = "Metodo que elimina los datos de OrdenCompra")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de OrdenCompra eliminados"),
            @ApiResponse(code = 404, message = "OrdenCompra no encontrado")
    })
    public ResponseEntity<OrdenCompra> deletePersonal(@PathVariable("id") Long id) {
        try {
            Optional<OrdenCompra> ordenCompraDeleted = ordenCompraService.getById(id);
            if (!ordenCompraDeleted.isPresent())
                return new ResponseEntity<OrdenCompra>(HttpStatus.NOT_FOUND);
            ordenCompraService.delete(id);
            return new ResponseEntity<OrdenCompra>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<OrdenCompra>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar OrdenCompra por Id", notes = "Métodos para encontrar una OrdenCompra por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OrdenCompra encontrado"),
            @ApiResponse(code = 404, message = "OrdenCompra no encontrado")
    })
    public ResponseEntity<OrdenCompra> findById(@PathVariable("id") Long id) {
        try {
            Optional<OrdenCompra> ordenCompraOptional = ordenCompraService.getById(id);
            if (!ordenCompraOptional.isPresent())
                return new ResponseEntity<OrdenCompra>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<OrdenCompra>(ordenCompraOptional.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<OrdenCompra>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByNumeroOrden/{numeroOrden}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar OrdenCompra por numeroOrden", notes = "Métodos para encontrar un OrdenCompra por su respectivo numeroOrden")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OrdenCompra encontrado"),
            @ApiResponse(code = 404, message = "OrdenCompra no encontrado")
    })
    public ResponseEntity<OrdenCompra> findByDni(@PathVariable("numeroOrden") Long numeroOrden) {
        try {
            OrdenCompra ordenCompra = ordenCompraService.findByNumeroOrden(numeroOrden);
            if (ordenCompra == null)
                return new ResponseEntity<OrdenCompra>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<OrdenCompra>(ordenCompra, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<OrdenCompra>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("searchByFormaPago/{formaPago}")
    @ApiOperation(value = "Buscar OrdenCompra por formaPago", notes = "Métodos para encontrar una OrdenCompra por su respectivo formaPago")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OrdenCompra encontrados"),
            @ApiResponse(code = 404, message = "OrdenCompra no encontrados")
    })
    public ResponseEntity<List<OrdenCompra>> findByMetodoPago(@PathVariable("formaPago") String formaPago) {
        try {
            List<OrdenCompra> ordenCompras = ordenCompraService.findByFormaPago(formaPago);
            if (ordenCompras.size() > 0)
                return new ResponseEntity<List<OrdenCompra>>(ordenCompras, HttpStatus.OK);
            else
                return new ResponseEntity<List<OrdenCompra>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<OrdenCompra>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
