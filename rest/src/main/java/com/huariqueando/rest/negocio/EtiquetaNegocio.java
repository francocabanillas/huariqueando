package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Etiqueta;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.EtiquetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaNegocio {
    @Autowired
    private EtiquetaRepositorio etiquetaRepositorio;

    public Etiqueta actualizarEtiqueta(Etiqueta etiqueta){
        return etiquetaRepositorio.save(etiqueta);
    }
}
