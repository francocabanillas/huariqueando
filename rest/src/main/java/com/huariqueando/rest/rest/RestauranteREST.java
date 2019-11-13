package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.RestauranteRegistro;
import com.huariqueando.rest.negocio.RestauranteNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class RestauranteREST {
    @Autowired
    private RestauranteNegocio restauranteNegocio;

    @PostMapping("/restauranteregistro")
    public RestauranteRegistro registrarRestaurante(@RequestBody RestauranteRegistro restauranteRegistro){
        return restauranteNegocio.registrarRestauranteInicial(restauranteRegistro);
    }

    @GetMapping("/restaurante/{id}")
    public Restaurante obtenerRestaurante(@PathVariable(value = "id") Long id){
        return restauranteNegocio.obtenerRestaurante(id);
    }

    @PutMapping("/restaurante/actualizar")
    public Restaurante actualizar(@RequestBody Restaurante restaurante){
        try {
            return restauranteNegocio.actualizar(restaurante);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No es posible actualizar");
        }

    }
}
