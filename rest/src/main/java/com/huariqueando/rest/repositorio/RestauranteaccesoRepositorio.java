package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.Restauranteacceso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteaccesoRepositorio extends CrudRepository<Restauranteacceso,Long> {

}
