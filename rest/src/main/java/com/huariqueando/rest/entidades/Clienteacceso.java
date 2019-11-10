package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clienteacceso database table.
 * 
 */
@Entity
@Table(name = "clienteacceso")
/*
@NamedQuery(name="Clienteacceso.findAll", query="SELECT c FROM Clienteacceso c")
*/
public class Clienteacceso implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idcliente;

	private String clave;

	private String usuario;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clientes_id")
	private Cliente cliente;

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}