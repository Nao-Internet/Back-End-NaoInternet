package com.naoInternet.Repository;

import com.naoInternet.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient,Long> {

    public List<Ingredient> findByName(String name);

}
