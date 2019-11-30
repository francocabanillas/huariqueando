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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nombre;

	private double precio;

	private String etiqueta;
	private String etiqueta2;
	private String etiqueta3;
	private String etiqueta4;
	private String etiqueta5;
	private double puntuacion;

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getEtiqueta2() {
		return etiqueta2;
	}

	public void setEtiqueta2(String etiqueta2) {
		this.etiqueta2 = etiqueta2;
	}

	public String getEtiqueta3() {
		return etiqueta3;
	}

	public void setEtiqueta3(String etiqueta3) {
		this.etiqueta3 = etiqueta3;
	}

	public String getEtiqueta4() {
		return etiqueta4;
	}

	public void setEtiqueta4(String etiqueta4) {
		this.etiqueta4 = etiqueta4;
	}

	public String getEtiqueta5() {
		return etiqueta5;
	}

	public void setEtiqueta5(String etiqueta5) {
		this.etiqueta5 = etiqueta5;
	}

	//bi-directional many-to-one association to Restaurante
	@ManyToOne
	@JoinColumn(name="restaurantes_id")
	private Restaurante restaurante;

	//bi-directional many-to-one association to Platospendiente
	@OneToMany(mappedBy="plato")
	private List<Platopendiente> platopendientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public List<Platopendiente> getPlatosluegos() {
		return platopendientes;
	}

	public void setPlatosluegos(List<Platopendiente> platosluegos) {
		this.platopendientes = platosluegos;
	}



}