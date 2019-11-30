package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Distrito;
import com.huariqueando.rest.repositorio.DistritoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoNegocio {
    @Autowired
    private DistritoRepositorio distritoRepositorio;



    public List<Distrito> obtenerDistritos(){
        return (List<Distrito>) distritoRepositorio.findAll();
    }

    public Distrito obtenerDistritosPorId(Long id){
        return distritoRepositorio.findById(id).get();
    }


}
