package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the platopuntuaciones database table.
 * 
 */
@Entity
@Table(name="platopuntuaciones")
public class Platopuntuacione implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idcliente;

	private int idplato;

	private byte puntuacion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clientes_id")
	private Cliente cliente;

	//bi-directional many-to-one association to Plato
	@ManyToOne
	@JoinColumn(name="platos_id")
	private Plato plato;

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdplato() {
		return idplato;
	}

	public void setIdplato(int idplato) {
		this.idplato = idplato;
	}

	public byte getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(byte puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}
}