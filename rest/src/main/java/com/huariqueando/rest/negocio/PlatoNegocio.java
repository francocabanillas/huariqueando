package com.huariqueando.rest.negocio;

import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoNegocio {
    @Autowired
    private PlatoRepositorio platoRepositorio;
    
}
