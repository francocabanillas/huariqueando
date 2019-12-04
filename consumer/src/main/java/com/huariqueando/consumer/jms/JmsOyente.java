package com.huariqueando.consumer.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huariqueando.consumer.entidades.Plato;
import com.huariqueando.consumer.entidades.Platopuntaje;
import com.huariqueando.consumer.negocio.Negocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsOyente {

    @Autowired
    private Negocio negocio;

    @JmsListener(destination="${jms.cola.destino}")
    public void miMensaje(String mensajeJson) {
        System.out.println("Recibido:" + mensajeJson);
        //mensajeJSON a Objeto Pedido
        ObjectMapper mapper = new ObjectMapper();
        try {
            Platopuntaje platopuntaje =  mapper.readValue(mensajeJson, Platopuntaje.class);
            //platopuntaje.setMensaje("Puntaje calificado");
            System.out.println(mensajeJson);
            Plato respuesta = negocio.registrarPuntuacionPlato(platopuntaje);//registra en la base de  datos
            if (respuesta==null) {
                System.out.println("Calificacion rechazada");
            }
            else {
                System.out.println("Calificacion Terminado");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            System.out.println("No se pudo registrar");
        }
    }
}
