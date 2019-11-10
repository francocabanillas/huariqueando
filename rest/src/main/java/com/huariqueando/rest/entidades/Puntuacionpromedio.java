package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puntuacionpromedio database table.
 * 
 */
@Entity
@Table(name = "puntuacionespromedio")
public class Puntuacionpromedio implements Serializable {

	@Id
	@Column(name="platos_id")
	private int platosId;

	private byte promedio;

	//bi-directional one-to-one association to Plato
	@OneToOne
	@JoinColumn(name="platos_id")
	private Plato plato;

	public int getPlatosId() {
		return platosId;
	}

	public void setPlatosId(int platosId) {
		this.platosId = platosId;
	}

	public byte getPromedio() {
		return promedio;
	}

	public void setPromedio(byte promedio) {
		this.promedio = promedio;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}
}