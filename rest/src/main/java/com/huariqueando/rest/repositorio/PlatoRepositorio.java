package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.Plato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoRepositorio extends CrudRepository<Plato,Long> {

    @Query("SELECT a FROM Plato a WHERE a.restaurantes_id=:xrestaurantes_id")
    public List<Plato> obtenerRestaurantePlatos(Long xrestaurantes_id);

}
