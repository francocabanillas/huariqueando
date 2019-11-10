package com.huariqueando.rest.entidades;

import javax.persistence.*;

@Entity
@Table(name = "platoetiquetas")
public class PlatoEtiqueta {
    @Id
    private Long idplato;
    private Long idetiqueta;

    //bi-directional many-to-one association to etiqueta
    @ManyToOne
    @JoinColumn(name="etiqueta_id")
    private Etiqueta etiqueta;

    //bi-directional many-to-one association to Plato
    @ManyToOne
    @JoinColumn(name="platos_id")
    private Plato plato;

    public Long getIdplato() {
        return idplato;
    }

    public void setIdplato(Long idplato) {
        this.idplato = idplato;
    }

    public Long getIdetiqueta() {
        return idetiqueta;
    }

    public void setIdetiqueta(Long idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
