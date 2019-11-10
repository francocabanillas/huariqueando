package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteNegocio {
    @Autowired
    private RestauranteRepositorio restauranteRepositorio;
    @Autowired
    private RestauranteaccesoNegocio restauranteaccesoNegocio;

    public Restaurante registrarRestaurante(Restaurante restaurante){
        return restauranteRepositorio.save(restaurante);
    }

    public Restaurante editarRestaurante(Restaurante restaurante){
        Restaurante actual = restauranteRepositorio.findById(restaurante.getId()).get();
        if (actual!=null){
            return restauranteRepositorio.save(restaurante);
        }
        else
            return null;
    }


}
