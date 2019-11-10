package com.huariqueando.rest.entidades;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the clienteacceso database table.
 * 
 */
@Entity
@Table(name = "restauranteacceso")
/*
@NamedQuery(name="Clienteacceso.findAll", query="SELECT c FROM Clienteacceso c")
*/
public class Restauranteacceso implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idrestaurante;

	private String clave;

	private String usuario;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="restaurante_id")
	private Restaurante restaurante;

	public Long getIdrestaurante() {
		return idrestaurante;
	}

	public void setIdrestaurante(Long idrestaurante) {
		this.idrestaurante = idrestaurante;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
}