package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.Restauranteacceso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteaccesoRepositorio extends CrudRepository<Restauranteacceso,Long> {

    @Query("SELECT a FROM Restauranteacceso a WHERE a.usuario=:xnombreUsuario")
    public List<Restauranteacceso> ExisteNombreUsuario(String xnombreUsuario);

}
