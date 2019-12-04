package com.huariqueando.consumer.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="platos")
public class Plato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private double precio;

    private String etiqueta;
    private String etiqueta2;
    private String etiqueta3;
    private String etiqueta4;
    private String etiqueta5;
    private Long distrito_id;
    private double puntuacion;
    //bi-directional many-to-one association to Restaurante
    @ManyToOne
    @JoinColumn(name="restaurantes_id")
    private Restaurante restaurante;


    public Long getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(Long distrito_id) {
        this.distrito_id = distrito_id;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta2() {
        return etiqueta2;
    }

    public void setEtiqueta2(String etiqueta2) {
        this.etiqueta2 = etiqueta2;
    }

    public String getEtiqueta3() {
        return etiqueta3;
    }

    public void setEtiqueta3(String etiqueta3) {
        this.etiqueta3 = etiqueta3;
    }

    public String getEtiqueta4() {
        return etiqueta4;
    }

    public void setEtiqueta4(String etiqueta4) {
        this.etiqueta4 = etiqueta4;
    }

    public String getEtiqueta5() {
        return etiqueta5;
    }

    public void setEtiqueta5(String etiqueta5) {
        this.etiqueta5 = etiqueta5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
