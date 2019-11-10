package com.huariqueando.rest.negocio;

import com.huariqueando.rest.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteNegocio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
}
