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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="platos_id")
	private Long platosId;

	private byte promedio;

	//bi-directional one-to-one association to Plato
	@OneToOne
	@JoinColumn(name="platos_id")
	private Plato plato;

	public Long getPlatosId() {
		return platosId;
	}

	public void setPlatosId(Long platosId) {
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