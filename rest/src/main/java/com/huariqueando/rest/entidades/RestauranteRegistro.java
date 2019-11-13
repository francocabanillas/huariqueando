package com.huariqueando.rest.entidades;

public class RestauranteRegistro {
    public enum tipoEstado {contraseñaCorta,existeUsuario,existeCorreo,Guardado, correoVacio,usuarioVacio,otrosErrores,
    registroExitoso}

    private String usuario;
    private String clave;
    private String correo;
    private tipoEstado Estado;

    private Restaurante restaurante;
    private Restauranteacceso restauranteacceso;

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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Restauranteacceso getRestauranteacceso() {
        return restauranteacceso;
    }

    public void setRestauranteacceso(Restauranteacceso restauranteacceso) {
        this.restauranteacceso = restauranteacceso;
    }
}
