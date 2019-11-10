package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Restauranteacceso;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import com.huariqueando.rest.repositorio.RestauranteaccesoRepositorio;
import com.huariqueando.rest.util.AccesoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteaccesoNegocio {
    @Autowired
    private RestauranteaccesoRepositorio restauranteaccesoRepositorio;
    @Autowired
    private AccesoUtil accesoUtil;

    public Restauranteacceso registrar(Restauranteacceso restauranteacceso){
        if (accesoUtil.esClavefuerte(restauranteacceso.getClave())) {
            return restauranteaccesoRepositorio.save(restauranteacceso);
        }
        else {
            return null;
        }
    }
}
