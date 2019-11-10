package com.huariqueando.rest.negocio;

import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.PuntuacionpromedioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntuacionpromedioNegocio {
    @Autowired
    private PuntuacionpromedioRepositorio puntuacionpromedioRepositorio;
    
}
