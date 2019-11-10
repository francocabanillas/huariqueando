package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
//@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String correo;

	private String nombre;

	private String token;

	private byte validado;

	//bi-directional many-to-one association to Clienteacceso
	@OneToMany(mappedBy="cliente")
	private List<Clienteacceso> clienteaccesos;

	//bi-directional many-to-one association to Platopuntuacione
	@OneToMany(mappedBy="cliente")
	private List<Platopuntuacione> platopuntuaciones;

	//bi-directional many-to-one association to Platosluego
	@OneToMany(mappedBy="cliente")
	private List<Platosluego> platosluegos;

	public List<Clienteacceso> getClienteaccesos() {
		return clienteaccesos;
	}

	public void setClienteaccesos(List<Clienteacceso> clienteaccesos) {
		this.clienteaccesos = clienteaccesos;
	}

	public List<Platopuntuacione> getPlatopuntuaciones() {
		return platopuntuaciones;
	}

	public void setPlatopuntuaciones(List<Platopuntuacione> platopuntuaciones) {
		this.platopuntuaciones = platopuntuaciones;
	}

	public List<Platosluego> getPlatosluegos() {
		return platosluegos;
	}

	public void setPlatosluegos(List<Platosluego> platosluegos) {
		this.platosluegos = platosluegos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public byte getValidado() {
		return validado;
	}

	public void setValidado(byte validado) {
		this.validado = validado;
	}
}