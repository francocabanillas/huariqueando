package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Plato;
import com.huariqueando.rest.entidades.PlatoRegistro;
import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.PlatoRepositorio;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoNegocio {
    @Autowired
    private PlatoRepositorio platoRepositorio;
    @Autowired
    private RestauranteRepositorio restauranteRepositorio;


    public List<Plato> obtenerRestaurantePlatos(Long restaurante_id){
        Restaurante r;
        r = restauranteRepositorio.findById(restaurante_id).get();
        if (r!=null){
            return (List<Plato>) platoRepositorio.obtenerRestaurantePlatos(r);
        }else
        {
            return null;
        }

    }

    public List<Plato> obtenerPlatos(Long restaurantes_id){
        return (List<Plato>) platoRepositorio.findAll();
    }

    public List<Plato> obtenerPlatosPorDistrito(String distrito){
        return (List<Plato>) platoRepositorio.findAll();
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
