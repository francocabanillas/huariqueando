package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Plato;
import com.huariqueando.rest.entidades.PlatoRegistro;
import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.negocio.PlatoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoREST {
    @Autowired
    private PlatoNegocio platoNegocio;

    @GetMapping("/Restaurante/platos/{id}")
    public List<Plato> obtenerRestaurantePlatos(@PathVariable(value = "restaurantes_id") Long restaurantes_id){
        return platoNegocio.obtenerRestaurantePlatos(restaurantes_id);
    }

    @PostMapping("/platoregistro")
    public Plato registrarPlatoRestaurante(@RequestBody PlatoRegistro platoRegistro){
        return platoNegocio.registrarPlatoRestaurante(platoRegistro);
    }
}
