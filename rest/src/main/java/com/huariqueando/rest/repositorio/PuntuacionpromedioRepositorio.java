package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.Puntuacionpromedio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionpromedioRepositorio extends CrudRepository<Puntuacionpromedio,Long> {

}
