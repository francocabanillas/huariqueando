package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente,Long> {
    @Query("SELECT a FROM Cliente a WHERE a.correo=:xcorreo")
    public List<Cliente> obtenerPorCorreo(String xcorreo);

    @Query("SELECT a FROM Cliente a WHERE a.usuario=:xnombreUsuario")
    public List<Cliente> ExisteNombreUsuario(String xnombreUsuario);
}
