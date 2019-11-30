package com.huariqueando.rest.entidades;

public class PlatoRegistro {
    private Long   restaurante_id;
    private String nombre;
    private double precio;


    public Long getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(Long restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
