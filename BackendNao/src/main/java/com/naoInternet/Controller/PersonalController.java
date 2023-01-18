package com.naoInternet.Controller;


import com.naoInternet.Entity.Personal;
import com.naoInternet.Service.IPersonalService;
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
@RequestMapping("/api/personal")
@Api(tags = "Personal",value = "Service Web RESTFul de Personal")
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar personal",notes = "Métodos para listar a todo el personal")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal encontrados"),
            @ApiResponse(code = 404, message = "Personal no encontrados")
    })
    public ResponseEntity<List<Personal>> findAll(){
        try {
            List<Personal> personals = personalService.getAll();
            //if (personals.size() > 0)
            return new ResponseEntity<List<Personal>>(personals, HttpStatus.OK);
            //else
            // return new ResponseEntity<List<Personal>>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            return new ResponseEntity<List<Personal>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de Personal", notes = "Método que registra Personal en BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal creado"),
            @ApiResponse(code = 404, message = "Personal no creado")
    })
    public ResponseEntity<Personal> insertPersonal(@Valid @RequestBody Personal personal) {
        try {
            Personal personalNew = personalService.save(personal);
            return ResponseEntity.status(HttpStatus.CREATED).body(personalNew);
        } catch (Exception e) {
            return new ResponseEntity<Personal>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualización de datos de Personal", notes = "Metodo que actualiza los datos de Personal")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de Personal actualizados"),
            @ApiResponse(code = 404, message = "Personal no encontrado")
    })
    public ResponseEntity<Personal> updatePersonal(
            @PathVariable("id") Long id, @Valid @RequestBody Personal personal) {
        try {
            Optional<Personal> personalUp = personalService.getById(id);
            if (!personalUp.isPresent())
                return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
            personal.setIdPersonal(id);
            personalService.save(personal);
            return new ResponseEntity<Personal>(personal, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Personal>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Eliminación de Personal", notes = "Metodo que elimina los datos de Personal")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Datos de Personal eliminados"),
            @ApiResponse(code = 404, message = "Personal no encontrado")
    })
    public ResponseEntity<Personal> deletePersonal(@PathVariable("id") Long id) {
        try {
            Optional<Personal> personalDelete = personalService.getById(id);
            if (!personalDelete.isPresent())
                return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
            personalService.delete(id);
            return new ResponseEntity<Personal>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Personal>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Personal por Id", notes = "Métodos para encontrar un personal por su respectivo Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal encontrado"),
            @ApiResponse(code = 404, message = "Personal no encontrado")
    })
    public ResponseEntity<Personal> findById(@PathVariable("id") Long id) {
        try {
            Optional<Personal> personalOptional = personalService.getById(id);
            if (!personalOptional.isPresent())
                return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Personal>(personalOptional.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Personal>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "searchByDni/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar Personal por DNI", notes = "Métodos para encontrar un personal por su respectivo DNI")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal encontrado"),
            @ApiResponse(code = 404, message = "Personal no encontrado")
    })
    public ResponseEntity<Personal> findByDni(@PathVariable("dni") Long dni) {
        try {
            Personal personal = personalService.findByDni(dni);
            if (personal == null)
                return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Personal>(personal, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Personal>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("searchByNombres/{nombres}")
    @ApiOperation(value = "Buscar Personal por nombre", notes = "Métodos para encontrar un Personal por su respectivo nombre")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal encontrados"),
            @ApiResponse(code = 404, message = "Personal no encontrados")
    })
    public ResponseEntity<List<Personal>> findByNombres(@PathVariable("nombres") String nombres) {
        try {
            List<Personal> personals = personalService.findByNombres(nombres);
            if (personals.size() > 0)
                return new ResponseEntity<List<Personal>>(personals, HttpStatus.OK);
            else
                return new ResponseEntity<List<Personal>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<Personal>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("searchByApellidos/{apellidos}")
    @ApiOperation(value = "Buscar Personal por apellidos", notes = "Métodos para encontrar un Personal por su respectivo apellido")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Personal encontrados"),
            @ApiResponse(code = 404, message = "Personal no encontrados")
    })
    public ResponseEntity<List<Personal>> findByApellidos(@PathVariable("apellidos") String apellidos) {
        try {
            List<Personal> personals = personalService.findByApellidos(apellidos);
            if (personals.size() > 0)
                return new ResponseEntity<List<Personal>>(personals, HttpStatus.OK);
            else
                return new ResponseEntity<List<Personal>>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<List<Personal>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
