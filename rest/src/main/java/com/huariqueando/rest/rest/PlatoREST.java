package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Distrito;
import com.huariqueando.rest.entidades.Plato;
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

    @GetMapping("/restaurante/platos/{id}")
    public List<Plato> obtenerRestaurantePlatos(@PathVariable(value = "id") Long id){
        return platoNegocio.obtenerRestaurantePlatos(id);
    }

    @GetMapping("/restaurante/platosdistrito/{id}")
    public List<Plato> obtenerRestauranteDistrito(@PathVariable(value = "id") Long id){
        return platoNegocio.obtenerRestauranteDistrito(id);
    }


    @PostMapping("/platoregistro/{id}")
    public Plato registrarPlatoRestaurante(@PathVariable(value = "id") Long id,@RequestBody Plato plato){
        Restaurante restaurante = new Restaurante();
        restaurante.setId(id);
        plato.setRestaurante(restaurante);
        return platoNegocio.registrarPlatoRestaurante(plato);
    }



}
