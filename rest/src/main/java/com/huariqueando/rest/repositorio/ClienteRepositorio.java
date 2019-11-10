package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente,Long> {

}
