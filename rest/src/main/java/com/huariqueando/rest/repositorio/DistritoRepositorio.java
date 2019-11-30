package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Distrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepositorio extends CrudRepository<Distrito,Long> {



}
