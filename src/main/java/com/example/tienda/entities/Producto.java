package com.example.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "PRODUCTO")
public class Producto {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column (name = "ID_PRODUCTO")
	private Long id;
	
	@Column (name = "NOMBRE")
	private String nombre;
		
	@Column (name = "PRECIO")
	private Float precio;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name = "STOCK")
	private String stock;

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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	
	
}
