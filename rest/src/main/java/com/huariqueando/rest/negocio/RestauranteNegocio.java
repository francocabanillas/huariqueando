package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.RestauranteRegistro;
import com.huariqueando.rest.entidades.Restauranteacceso;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


        if (restauranteRegistro.getCorreo().isEmpty()){
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.correoVacio);
            return restauranteRegistro;
        }

        if (restauranteRegistro.getUsuario().isEmpty()){
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.usuarioVacio);
            return restauranteRegistro;
        }

        if (restauranteRegistro.getClave().isEmpty()){
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.usuarioVacio);
            return restauranteRegistro;
        }

        if (restauranteaccesoNegocio.existeNombreUsuario(restauranteRegistro.getUsuario()))
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.existeUsuario);;
            return restauranteRegistro;
        }

        if (existeCorreo(restauranteRegistro.getCorreo()))
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.existeCorreo);;
            return restauranteRegistro;
        }

        Restaurante restaurante = new Restaurante();
        Restauranteacceso restauranteacceso = new Restauranteacceso();

        restaurante.setCorreo(restauranteRegistro.getCorreo());
        restaurante.setNombre(restauranteRegistro.getUsuario());
        restaurante.setValidado(false);

        restauranteRegistro.setRestaurante(restauranteRepositorio.save(restaurante));

        if (restauranteRegistro.getRestaurante()!=null){

            restauranteacceso.setIdrestaurante(restauranteRegistro.getRestaurante().getId());
            restauranteacceso.setRestaurante(restauranteRegistro.getRestaurante());
            restauranteacceso.setUsuario(restauranteRegistro.getUsuario());
            restauranteacceso.setClave(restauranteRegistro.getClave());

            restauranteRegistro.setRestauranteacceso(restauranteaccesoNegocio.registrar(restauranteacceso));

        }

       if ((restauranteRegistro.getRestaurante()!=null)||(restauranteRegistro.getRestauranteacceso()!=null)){
           restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.registroExitoso);
           return restauranteRegistro;
        }else
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.otrosErrores);
            return restauranteRegistro;
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

    public Restaurante obtenerRestaurante(Long id){
        return restauranteRepositorio.findById(id).get();
    }


    public Restaurante actualizar(Restaurante restaurante) {
        Restaurante p = restauranteRepositorio.findById(restaurante.getId()).get();
        if (p != null) {
            return restauranteRepositorio.save(restaurante);
        } else {
            return null;
        }
    }



}
