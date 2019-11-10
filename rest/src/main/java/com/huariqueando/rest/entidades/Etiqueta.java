package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etiquetas database table.
 * 
 */
@Entity
@Table(name="etiquetas")
public class Etiqueta implements Serializable {

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-many association to Plato
	@ManyToMany(mappedBy="etiquetas")
	private List<Plato> platos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
}