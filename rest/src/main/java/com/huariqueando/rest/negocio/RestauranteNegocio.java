package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Distrito;
import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.RestauranteRegistro;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import com.huariqueando.rest.util.AccesoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteNegocio {
    @Autowired
    private RestauranteRepositorio restauranteRepositorio;

    private AccesoUtil accesoUtil;

    public Restaurante registrarRestaurante(Restaurante restaurante){
        return restauranteRepositorio.save(restaurante);
    }


    public boolean existeNombreUsuario(String nombreUsuario){
        List<Restaurante> list;
        list = restauranteRepositorio.ExisteNombreUsuario(nombreUsuario);
        return !(list.isEmpty());
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

    private RestauranteRegistro ValidarRegistro(RestauranteRegistro restauranteRegistro){
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

        if (existeNombreUsuario(restauranteRegistro.getUsuario()))
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.existeUsuario);;
            return restauranteRegistro;
        }

        if (existeCorreo(restauranteRegistro.getCorreo()))
        {
            restauranteRegistro.setEstado(RestauranteRegistro.tipoEstado.existeCorreo);;
            return restauranteRegistro;
        }

        return restauranteRegistro;
    }

    public RestauranteRegistro registrarRestauranteInicial(RestauranteRegistro restauranteRegistro){


        restauranteRegistro = ValidarRegistro(restauranteRegistro);

        if (!restauranteRegistro.getEstado().equals(RestauranteRegistro.tipoEstado.pendiente)){
            return restauranteRegistro;
        }

        Restaurante restaurante = new Restaurante();

        restaurante.setCorreo(restauranteRegistro.getCorreo());
        restaurante.setNombre(restauranteRegistro.getUsuario());
        restaurante.setValidado(false);
        restaurante.setUsuario(restauranteRegistro.getUsuario());
        restaurante.setClave(restauranteRegistro.getClave());
        restauranteRegistro.setRestaurante(restauranteRepositorio.save(restaurante));

       if (restauranteRegistro.getRestaurante()!=null){
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


    public Restaurante actualizarRestaurante(Restaurante restaurante) {
        Restaurante p = restauranteRepositorio.findById(restaurante.getId()).get();
        if (p != null) {
            restaurante.setUsuario(p.getUsuario());
            restaurante.setClave(p.getClave());
            restaurante.setCorreo(p.getCorreo());
            restaurante.setToken(p.getToken());
            restaurante.setValidado(p.getValidado());
            return restauranteRepositorio.save(restaurante);
        } else {
            return null;
        }
    }

    public Restaurante iniciarSesion(String correo, String clave){
        return restauranteRepositorio.ExisteCorreoyClave(correo,clave);
    }




}
