package com.naoInternet.Repository;

import com.naoInternet.Entity.Beginner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBeginnerRepository extends JpaRepository<Beginner,Long> {
    public Beginner findByDni(String dni);
    public List<Beginner> findByLastName(String lastname);
    public List<Beginner> findByFirstName(String firstname);
    public List<Beginner> findByFirstNameAndLastName(String firstname, String lastname);

}
