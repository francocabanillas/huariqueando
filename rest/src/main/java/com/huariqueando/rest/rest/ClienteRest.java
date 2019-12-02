package com.huariqueando.rest.rest;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.ClienteRegistro;
import com.huariqueando.rest.negocio.ClienteNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ClienteRest {
    @Autowired
    private ClienteNegocio clienteNegocioNegocio;

    @PostMapping("/clienteregistro")
    public ClienteRegistro registrarCliente(@RequestBody ClienteRegistro clienteRegistro){
        return clienteNegocioNegocio.registrarClienteInicial(clienteRegistro);
    }

    @GetMapping("/cliente/{id}")
    public Cliente obtenerCliente(@PathVariable(value = "id") Long id){
        return clienteNegocioNegocio.obtenerCliente(id);
    }

    @PutMapping("/cliente/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente){
        try {
            cliente.setId(id);
            return clienteNegocioNegocio.actualizarCliente(cliente);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No es posible actualizar");
        }

    }
}
