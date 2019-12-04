package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.*;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.repositorio.PlatoRepositorio;
import com.huariqueando.rest.repositorio.PlatopuntajeRepositorio;
import com.huariqueando.rest.repositorio.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoNegocio {
    @Autowired
    private PlatoRepositorio platoRepositorio;
    @Autowired
    private RestauranteRepositorio restauranteRepositorio;
    @Autowired
    private PlatopuntajeRepositorio platopuntajeRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Plato> obtenerRestaurantePlatos(Long restaurante_id){
        Restaurante r;
        r = restauranteRepositorio.findById(restaurante_id).get();
        if (r!=null){
            return (List<Plato>) platoRepositorio.obtenerRestaurantePlatos(r);
        }else
        {
            return null;
        }

    }

    public void ActualizarPlatoDistrito(Restaurante restaurante){
        List<Plato> platos = new ArrayList<>();
        platos = platoRepositorio.obtenerRestaurantePlatos(restaurante);
        for (Plato p: platos
        ) {
            p.setDistrito_id(restaurante.getDistrito_id());
            platoRepositorio.save(p);
        }
    }

    public List<Plato> obtenerPlatos(Long restaurantes_id){
        return (List<Plato>) platoRepositorio.findAll();
    }

    public List<Plato> obtenerRestauranteDistrito(Long distrito_id){
        return (List<Plato>) platoRepositorio.obtenerRestauranteDistrito(distrito_id);
    }

    public Plato registrarPlatoRestaurante(Plato plato ){
        return platoRepositorio.save(plato);
    }

    public Plato recalcularPuntaje(Long id){

        Plato plato = new Plato();
        List<Platopuntaje> platopuntajes = new ArrayList<>();

        Integer suma=0;

        plato=platoRepositorio.findById(id).get();
        platopuntajes=platopuntajeRepositorio.obtenerPlatosPorIdPlato(id);

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
            return (platopuntajeRepositorio.cantidadPorCliente(idcliente)>100);
        }
        else
            return false;
    }


    public Plato registrarPuntuacionPlato(Platopuntaje platopuntaje){
        Plato platoActual = new Plato();
        if (superoTopeInvitado(platopuntaje.getCliente_id())){
            return platoActual;
        }


        Cliente clienteActual = new Cliente();
        platoActual=platoRepositorio.findById(platopuntaje.getPlato_id()).get();
        clienteActual=clienteRepositorio.findById(platopuntaje.getCliente_id()).get();
        if (platoActual!=null||clienteActual!=null){
            platopuntajeRepositorio.save(platopuntaje);
            platoActual =  recalcularPuntaje(platopuntaje.getPlato_id());

            return platoActual;
        }
        else
        {
            return platoActual;
        }

       /* return null;*/


    }

}
