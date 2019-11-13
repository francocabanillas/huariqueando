package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.RestauranteRegistro;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.huariqueando.rest.entidades.RestauranteRegistro.estado.existeUsuario;

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

    public Boolean existeCorreo(String correo){
        return !(restauranteRepositorio.obtenerRestaurantePorCorreo(correo).isEmpty());
    }

    public RestauranteRegistro registrarRestauranteInicial(RestauranteRegistro restauranteRegistro){


        if (restauranteRegistro.getRestaurante().getCorreo().isEmpty()){
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.correoVacio);
            return restauranteRegistro;
        }

        if (restauranteRegistro.getRestauranteacceso().getUsuario().isEmpty()){
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.usuarioVacio);
            return restauranteRegistro;
        }

        if (restauranteaccesoNegocio.existeNombreUsuario(restauranteRegistro.getRestauranteacceso().getUsuario()))
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.existeUsuario);;
            return restauranteRegistro;
        }

        if (existeCorreo(restauranteRegistro.getRestaurante().getCorreo()))
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.existeCorreo);;
            return restauranteRegistro;
        }

        RestauranteRegistro registro = new RestauranteRegistro();

        registro.setRestaurante(restauranteRepositorio.save(restauranteRegistro.getRestaurante()));
        registro.setRestauranteacceso(restauranteaccesoNegocio.registrar(restauranteRegistro.getRestauranteacceso()));
        if ((registro.getRestaurante()!=null)||(registro.getRestauranteacceso()!=null)){
        return registro;
        }else
        {
            registro.setEstado(RestauranteRegistro.tipoEstado.otrosErrores)
            return registro;
        }
    }

    public Restaurante validarCorreo(Restaurante restaurante){
        if (restaurante.getToken().length()>0){
            restaurante.setValidado(true);
            return restauranteRepositorio.save(restaurante);
        }
        else {
            restaurante.setValidado(false);
            return restauranteRepositorio.save(restaurante);
        }

    }



}
