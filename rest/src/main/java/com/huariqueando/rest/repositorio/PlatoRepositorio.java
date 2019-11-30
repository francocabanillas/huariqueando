package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.Distrito;
import com.huariqueando.rest.entidades.Plato;
import com.huariqueando.rest.entidades.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoRepositorio extends CrudRepository<Plato,Long> {

    @Query("SELECT a FROM Plato a Where a.restaurante=:xrestaurante_id")
    public List<Plato> obtenerRestaurantePlatos(Restaurante xrestaurante_id);

    @Query("SELECT a FROM Plato a Where a.distrito_id=:xdistrito_id")
    public List<Plato> obtenerRestauranteDistrito(Long xdistrito_id);

}
