package com.huariqueando.rest.negocio;

import com.huariqueando.rest.repositorio.PlatopuntajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatopuntajeNegocio {
    @Autowired
    private PlatopuntajeRepositorio platopuntajeRepositorio;
    
}
