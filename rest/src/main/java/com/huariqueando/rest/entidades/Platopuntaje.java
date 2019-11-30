package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the platopuntuaciones database table.
 * 
 */
@Entity
@Table(name="platopuntajes")
public class Platopuntaje implements Serializable {

	@Id
	private Long id;
	private Long id_cliente;
	private Long id_plato;

	private byte puntuacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Long getId_plato() {
		return id_plato;
	}

	public void setId_plato(Long id_plato) {
		this.id_plato = id_plato;
	}

	public byte getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(byte puntuacion) {
		this.puntuacion = puntuacion;
	}
}