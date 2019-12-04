package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Restaurante;
import com.huariqueando.rest.entidades.RestauranteRegistro;
import com.huariqueando.rest.negocio.RestauranteNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
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

    @GetMapping("/restaurantes")
    public List<Restaurante> obteRestaurantes(){ return restauranteNegocio.obtenerRestaurantes();}

    @PutMapping("/restaurante/actualizar/{id}")
    public Restaurante actualizarRestaurante(@PathVariable(value = "id") Long id, @RequestBody Restaurante restaurante){
        System.out.print("f");
        try {
            restaurante.setId(id);
            return restauranteNegocio.actualizarRestaurantes(restaurante);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }

    }


    @PostMapping("/restaurante/iniciasesion")
    @CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public Restaurante actualizarRestaurante(@RequestBody Restaurante restaurante){
        try {
            return restauranteNegocio.iniciarSesion(restaurante.getCorreo(),restaurante.getClave());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe usuario");
        }

    }
}
