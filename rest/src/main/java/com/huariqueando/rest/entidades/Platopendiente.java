package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the platosluego database table.
 * 
 */
@Entity
@Table(name = "platospendientes")
public class Platopendiente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clientes_id")
	private Cliente cliente;

	//bi-directional many-to-one association to Plato
	@ManyToOne
	@JoinColumn(name="platos_id")
	private Plato plato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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