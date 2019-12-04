package com.huariqueando.send.entidades;

import java.io.Serializable;

public class Restaurante implements Serializable {

    private Long id;
    private String direccion;
    private String correo;
    private String identificacion;
    private String nombre;
    private String telefono;
    private Long distrito_id;
    private String usuario;
    private String clave;
    private String token;

    private Boolean validado;
}
