package com.huariqueando.rest.repositorio;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepositorio extends CrudRepository<Restaurante,Long> {

    @Query("SELECT a FROM Restaurante a WHERE a.correo=:xcorreo")
    public List<Restaurante> obtenerRestaurantePorCorreo(String xcorreo);

    @Query("SELECT a FROM Restaurante a WHERE a.usuario=:xnombreUsuario")
    public List<Restaurante> ExisteNombreUsuario(String xnombreUsuario);

    @Query("SELECT a FROM Restaurante a WHERE a.correo=:xcorreo and a.clave=:xclave")
    public Restaurante ExisteCorreoyClave(String xcorreo, String xclave);
}
