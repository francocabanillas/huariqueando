package com.huariqueando.send.entidades;

import java.io.Serializable;

public class Platopuntaje  implements Serializable {
    private Long id;
    private Long cliente_id;
    private Long plato_id;
    private Integer puntuacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Long getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(Long plato_id) {
        this.plato_id = plato_id;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
