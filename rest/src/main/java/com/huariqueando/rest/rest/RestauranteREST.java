package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.RestauranteRegistro;
import com.huariqueando.rest.negocio.RestauranteNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestauranteREST {
    @Autowired
    private RestauranteNegocio restauranteNegocio;

    @PostMapping("/Restaurante/Registrar")
    public RestauranteRegistro registrarRestaurante(@RequestBody RestauranteRegistro restauranteRegistro){
        return restauranteNegocio.registrarRestauranteInicial(restauranteRegistro);
    }
}
