package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Distrito;
import com.huariqueando.rest.negocio.DistritoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistritoREST {

    @Autowired
    private DistritoNegocio distritoNegocio;


    @GetMapping("/distritos")
    public List<Distrito> obtenerDistritos(){
        return distritoNegocio.obtenerDistritos();
    }

    @GetMapping("/distrito/{id}")
    public Distrito obtenerDistritosPorId(@PathVariable(value = "id") Long id){
        return distritoNegocio.obtenerDistritosPorId(id);
    }
}
