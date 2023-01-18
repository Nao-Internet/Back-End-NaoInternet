package com.naoInternet.Repository;

import com.naoInternet.Entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonalRepository extends JpaRepository<Personal, Long> {

    public Personal findByDni(Long dni);

    public List<Personal> findByNombres(String nombres);

    public List<Personal> findByApellidos(String apellidos);

}
