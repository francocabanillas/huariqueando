package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.Clienteacceso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteAccesoRepositorio extends CrudRepository<Clienteacceso,Long> {

}
