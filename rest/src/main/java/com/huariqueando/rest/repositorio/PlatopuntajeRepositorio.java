package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Platopuntaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatopuntajeRepositorio extends CrudRepository<Platopuntaje,Long> {
    @Query("SELECT a FROM Platopuntaje a WHERE a.plato_id=:xplato_id")
    public List<Platopuntaje> obtenerPlatosPorIdPlato(Long xplato_id);

    @Query("SELECT count(a) FROM Platopuntaje a WHERE a.cliente_id=:xcliente_id")
    public Integer cantidadPorCliente(Long xcliente_id);
}