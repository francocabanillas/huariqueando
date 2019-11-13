package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Restauranteacceso;
import com.huariqueando.rest.repositorio.RestauranteaccesoRepositorio;
import com.huariqueando.rest.util.AccesoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteaccesoNegocio {
    @Autowired
    private RestauranteaccesoRepositorio restauranteaccesoRepositorio;

    private AccesoUtil accesoUtil;

    public boolean existeNombreUsuario(String nombreUsuario){
        List<Restauranteacceso> list;
        list = restauranteaccesoRepositorio.ExisteNombreUsuario(nombreUsuario);
        return !(list.isEmpty());
    }

    public Restauranteacceso registrar(Restauranteacceso restauranteacceso){
        accesoUtil = new AccesoUtil();
        if (accesoUtil.esClavefuerte(restauranteacceso.getClave())) {
            return restauranteaccesoRepositorio.save(restauranteacceso);
        }
        else {
            return null;
        }
    }
}
