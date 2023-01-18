package com.naoInternet.Service;

import com.naoInternet.Entity.Personal;

import java.util.List;

public interface IPersonalService extends CrudService<Personal> {

    public Personal findByDni(Long dni) throws Exception;

    public List<Personal> findByNombres(String nombres) throws Exception;

    public List<Personal> findByApellidos(String apellidos) throws Exception;

}
