package com.naoInternet.Repository;

import com.naoInternet.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Long> {
    public List<Country> findByCountryName(String name);
}
