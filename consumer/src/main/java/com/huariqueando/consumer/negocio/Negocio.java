package com.huariqueando.consumer.negocio;

import com.huariqueando.consumer.entidades.Plato;
import com.huariqueando.consumer.entidades.Platopuntaje;
import com.huariqueando.consumer.repositorio.PlatoPuntajeRepositorio;
import com.huariqueando.consumer.repositorio.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Negocio {
    @Autowired
    private PlatoPuntajeRepositorio platoPuntajeRepositorio;
    @Autowired
    private PlatoRepositorio platoRepositorio;

    public Plato recalcularPuntaje(Long id){

        Plato plato = new Plato();
        List<Platopuntaje> platopuntajes = new ArrayList<>();

        Integer suma=0;

        plato=platoRepositorio.findById(id).get();
        platopuntajes=platoPuntajeRepositorio.obtenerPlatosPorIdPlato(id);

        for (Platopuntaje puntaje: platopuntajes) {
            suma=suma+puntaje.getPuntuacion();
        }

        if (platopuntajes.size()>0)
            plato.setPuntuacion(suma/platopuntajes.size());
        else
            plato.setPuntuacion(0);


        return platoRepositorio.save(plato);

    }

    public Boolean superoTopeInvitado(Long idcliente){
        if (idcliente.equals(1)){
            return (platoPuntajeRepositorio.cantidadPorCliente(idcliente)>100);
        }
        else
            return false;
    }

    @Transactional
    public Plato registrarPuntuacionPlato(Platopuntaje platopuntaje){
        Plato platoActual = new Plato();
        if (superoTopeInvitado(platopuntaje.getCliente_id())){
            return platoActual;
        }

        platoActual=platoRepositorio.findById(platopuntaje.getPlato_id()).get();
        if (platoActual!=null){
            platoPuntajeRepositorio.save(platopuntaje);
            platoActual =  recalcularPuntaje(platopuntaje.getPlato_id());

            return platoActual;
        }
        else
        {
            return platoActual;
        }

    }
}
