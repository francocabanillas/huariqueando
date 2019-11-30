package com.huariqueando.rest.negocio;

import com.huariqueando.rest.entidades.Cliente;
import com.huariqueando.rest.entidades.ClienteRegistro;
import com.huariqueando.rest.repositorio.ClienteRepositorio;
import com.huariqueando.rest.util.AccesoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteNegocio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    private AccesoUtil accesoUtil;

    public boolean existeNombreUsuario(String nombreUsuario){
        List<Cliente> list;
        list = clienteRepositorio.ExisteNombreUsuario(nombreUsuario);
        return !(list.isEmpty());
    }


    public Cliente editarCliente(Cliente cliente){
        Cliente actual = clienteRepositorio.findById(cliente.getId()).get();
        if (actual!=null){
            return clienteRepositorio.save(cliente);
        }
        else
            return null;
    }

    public Boolean existeCorreo(String correo){
        return !(clienteRepositorio.obtenerPorCorreo(correo).isEmpty());
    }

    private ClienteRegistro ValidarRegistro(ClienteRegistro clienteRegistro){
        if (clienteRegistro.getCorreo().isEmpty()){
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.correoVacio);
            return clienteRegistro;
        }

        if (clienteRegistro.getUsuario().isEmpty()){
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.usuarioVacio);
            return clienteRegistro;
        }

        if (clienteRegistro.getClave().isEmpty()){
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.usuarioVacio);
            return clienteRegistro;
        }

        if (existeNombreUsuario(clienteRegistro.getUsuario()))
        {
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.existeUsuario);;
            return clienteRegistro;
        }

        if (existeCorreo(clienteRegistro.getCorreo()))
        {
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.existeCorreo);;
            return clienteRegistro;
        }

        return clienteRegistro;
    }

    public ClienteRegistro registrarClienteInicial(ClienteRegistro clienteRegistro){


        clienteRegistro = ValidarRegistro(clienteRegistro);

        if (!clienteRegistro.getEstado().equals(ClienteRegistro.tipoEstado.pendiente)){
            return clienteRegistro;
        }

        Cliente cliente = new Cliente();

        cliente.setCorreo(clienteRegistro.getCorreo());
        cliente.setNombre(clienteRegistro.getUsuario());
        cliente.setValidado(false);
        cliente.setUsuario(clienteRegistro.getUsuario());
        cliente.setClave(clienteRegistro.getClave());
        clienteRegistro.setCliente(clienteRepositorio.save(cliente));

        if (clienteRegistro.getCliente()!=null){
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.registroExitoso);
            return clienteRegistro;
        }else
        {
            clienteRegistro.setEstado(ClienteRegistro.tipoEstado.otrosErrores);
            return clienteRegistro;
        }

    }

    public Cliente validarCorreo(Cliente cliente){
        if (cliente.getToken().length()>0){
            cliente.setValidado(true);
            return clienteRepositorio.save(cliente);
        }
        else {
            cliente.setValidado(false);
            return clienteRepositorio.save(cliente);
        }

    }

    public Cliente obtenerCliente(Long id){
        return clienteRepositorio.findById(id).get();
    }


    public Cliente actualizarCliente(Cliente cliente) {
        Cliente p = clienteRepositorio.findById(cliente.getId()).get();
        if (p != null) {
            cliente.setUsuario(p.getUsuario());
            cliente.setClave(p.getClave());
            cliente.setCorreo(p.getCorreo());
            cliente.setToken(p.getToken());
            cliente.setValidado(p.isValidado());
            return clienteRepositorio.save(cliente);
        } else {
            return null;
        }
    }

}
