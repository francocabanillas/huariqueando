package com.huariqueando.rest.entidades;

public class RestauranteRegistro {
    public enum tipoEstado {contraseñaCorta,existeUsuario,existeCorreo,Guardado, correoVacio,usuarioVacio,otrosErrores,
    registroExitoso}

    private Restaurante restaurante;
    private Restauranteacceso restauranteacceso;
    private tipoEstado Estado;


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

    public tipoEstado getEstado() {
        return Estado;
    }

    public void setEstado(tipoEstado estado) {
        Estado = estado;
    }
}
