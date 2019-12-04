package com.huariqueando.send.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huariqueando.send.entidades.Plato;
import com.huariqueando.send.entidades.Platopuntaje;
import com.huariqueando.send.jms.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class JmsRest {
    @Autowired
    private JmsProducer jmsProducer;

    @PostMapping("/platopuntaje")
    public Platopuntaje enviar(@RequestBody Platopuntaje platopuntaje) {
        ObjectMapper mapper = new ObjectMapper();
        //Object a JSON en String
        String jsonString=null;
        try {
            jsonString = mapper.writeValueAsString(platopuntaje);
            //se envía a la cola en String
            jmsProducer.send(jsonString);
            System.out.println("Pedido enviado");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error");
        }
        return platopuntaje;
    }
}
