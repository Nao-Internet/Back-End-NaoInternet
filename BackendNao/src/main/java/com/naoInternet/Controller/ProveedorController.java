package com.naoInternet.Controller;

import com.naoInternet.Entity.Proveedor;
import com.naoInternet.Service.IProveedorService;
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
@RequestMapping("/api/proveedor")
@Api(tags = "Proveedor", value = "Service Web RESTFul de Personal")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar proveedores",notes = "Métodos para listar a todos los proveedores")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Proveedores encontrados"),
            @ApiResponse(code = 404, message = "Proveedores no encontrados")
    })
    public ResponseEntity<List<Proveedor>> findAll(){
        try {
            List<Proveedor> proveedores = proveedorService.getAll();
            //if (proveedores.size() > 0)
            return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
            //else
            // return new ResponseEntity<List<Personal>>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            return new ResponseEntity<List<Proveedor>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Proveedor", notes = "Método que registra Proveedor en BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Proveedor creado"),
            @ApiResponse(code = 404, message = "Proveedor no creado")
    })
    public ResponseEntity<Proveedor> insertProveedor(@Valid @RequestBody Proveedor proveedor) {
        try {
            Proveedor proveedorNew = proveedorService.save(proveedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(proveedorNew);
        } catch (Exception e) {
            return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualización de datos de Proveedor", notes = "Metodo que actualiza los datos de Proveedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de Proveedor actualizados"),
            @ApiResponse(code = 404, message = "Proveedor no encontrado")
    })
    public ResponseEntity<Proveedor> updatePersonal(
            @PathVariable("id") Long id, @Valid @RequestBody Proveedor proveedor) {
        try {
            Optional<Proveedor> proveedorUp = proveedorService.getById(id);
            if (!proveedorUp.isPresent())
                return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
            proveedor.setIdProveedor(id);
            proveedorService.save(proveedor);
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Eliminación de Proveedor", notes = "Metodo que elimina los datos de Proveedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de Proveedor eliminados"),
            @ApiResponse(code = 404, message = "Proveedor no encontrado")
    })
    public ResponseEntity<Proveedor> deletePersonal(@PathVariable("id") Long id) {
        try {
            Optional<Proveedor> proveedorDelete = proveedorService.getById(id);
            if (!proveedorDelete.isPresent())
                return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
            proveedorService.delete(id);
            return new ResponseEntity<Proveedor>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Proveedor por Id", notes = "Métodos para encontrar un Proveedor por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Proveedor encontrado"),
            @ApiResponse(code = 404, message = "Proveedor no encontrado")
    })
    public ResponseEntity<Proveedor> findById(@PathVariable("id") Long id) {
        try {
            Optional<Proveedor> proveedorOptional = proveedorService.getById(id);
            if (!proveedorOptional.isPresent())
                return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Proveedor>(proveedorOptional.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByRuc/{ruc}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Proveedor por RUC", notes = "Métodos para encontrar un personal por su respectivo RUC")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal encontrado"),
            @ApiResponse(code = 404, message = "Personal no encontrado")
    })
    public ResponseEntity<Proveedor> findByDni(@PathVariable("ruc") Long ruc) {
        try {
            Proveedor proveedor = proveedorService.findByRuc(ruc);
            if (proveedor == null)
                return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("searchByNombresProveedor/{nombresProveedor}")
    @ApiOperation(value = "Buscar Proveedor por nombre", notes = "Métodos para encontrar un Proveedor por su respectivo nombre")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Proveedor encontrados"),
            @ApiResponse(code = 404, message = "Proveedor no encontrados")
    })
    public ResponseEntity<List<Proveedor>> findByNombresProveedor(@PathVariable("nombresProveedor") String nombresProveedor) {
        try {
            List<Proveedor> proveedores = proveedorService.findByNombresProveedor(nombresProveedor);
            if (proveedores.size() > 0)
                return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
            else
                return new ResponseEntity<List<Proveedor>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<Proveedor>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("searchByRazonSocial/{razonSocial}")
    @ApiOperation(value = "Buscar Proveedor por Razon Social", notes = "Métodos para encontrar un Proveedor por su respectiva razon social")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Proveedor encontrados"),
            @ApiResponse(code = 404, message = "Proveedor no encontrados")
    })
    public ResponseEntity<List<Proveedor>> findByRazonSocial(@PathVariable("razonSocial") String razonSocial) {
        try {
            List<Proveedor> proveedores = proveedorService.findByRazonSocial(razonSocial);
            if (proveedores.size() > 0)
                return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
            else
                return new ResponseEntity<List<Proveedor>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<Proveedor>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }



}
