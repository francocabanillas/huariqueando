package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Plato;
import com.huariqueando.rest.entidades.PlatoRegistro;
import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoNegocio {
    @Autowired
    private PlatoRepositorio platoRepositorio;

    public List<Plato> obtenerRestaurantePlatos(Long restaurantes_id){
        return  platoRepositorio.obtenerRestaurantePlatos(restaurantes_id);
    }

    public Plato registrarPlatoRestaurante(PlatoRegistro platoRegistro ){
        Plato plato = new Plato();
        Restaurante restaurante = new Restaurante();
        restaurante.setId(platoRegistro.getRestaurante_id());
        plato.setNombre(platoRegistro.getNombre());
        plato.setPrecio(platoRegistro.getPrecio());
        plato.setRestaurante(restaurante);

        return platoRepositorio.save(plato);
    }

}
