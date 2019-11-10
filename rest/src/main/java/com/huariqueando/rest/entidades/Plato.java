package com.huariqueando.rest.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the platos database table.
 * 
 */
@Entity
@Table(name="platos")
public class Plato implements Serializable {

	@Id
	private int id;

	private String nombre;

	private double precio;

	//bi-directional many-to-one association to Platopuntuacione
	@OneToMany(mappedBy="plato")
	private List<Platopuntuacione> platopuntuaciones;

	//bi-directional many-to-one association to Restaurante
	@ManyToOne
	@JoinColumn(name="restaurantes_id")
	private Restaurante restaurante;

	//bi-directional many-to-many association to Etiqueta
	@ManyToMany
	@JoinTable(
		name="platosetiquetas"
		, joinColumns={
			@JoinColumn(name="platos_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="etiquetas_id")
			}
		)
	private List<Etiqueta> etiquetas;

	//bi-directional many-to-one association to Platosluego
	@OneToMany(mappedBy="plato")
	private List<Platosluego> platosluegos;

	//bi-directional one-to-one association to Puntuacionpromedio
	@OneToOne(mappedBy="plato")
	private Puntuacionpromedio puntuacionpromedio;

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Platopuntuacione> getPlatopuntuaciones() {
		return platopuntuaciones;
	}

	public void setPlatopuntuaciones(List<Platopuntuacione> platopuntuaciones) {
		this.platopuntuaciones = platopuntuaciones;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<Platosluego> getPlatosluegos() {
		return platosluegos;
	}

	public void setPlatosluegos(List<Platosluego> platosluegos) {
		this.platosluegos = platosluegos;
	}

	public Puntuacionpromedio getPuntuacionpromedio() {
		return puntuacionpromedio;
	}

	public void setPuntuacionpromedio(Puntuacionpromedio puntuacionpromedio) {
		this.puntuacionpromedio = puntuacionpromedio;
	}
}