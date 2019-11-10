package com.huariqueando.rest.negocio;

import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.PlatopuntuacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoluegoNegocio {
    @Autowired
    private PlatopuntuacionRepositorio platopuntuacionRepositorio;
    
}
