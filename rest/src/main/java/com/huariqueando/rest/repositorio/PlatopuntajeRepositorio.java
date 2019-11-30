package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Platopuntaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatopuntajeRepositorio extends CrudRepository<Platopuntaje,Long> {

}