package com.huariqueando.rest.entidades;

public class ClienteRegistro {
        public enum tipoEstado {pendiente,contraseñaCorta,existeUsuario,existeCorreo,Guardado, correoVacio,usuarioVacio,otrosErrores,
        registroExitoso}

    private String usuario;
    private String clave;
    private String correo;
    private tipoEstado Estado;

    private Cliente cliente ;

    public ClienteRegistro() {
        Estado=tipoEstado.pendiente;
        usuario="";
        clave="";
        correo="";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public tipoEstado getEstado() {
        return Estado;
    }

    public void setEstado(tipoEstado estado) {
        Estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
