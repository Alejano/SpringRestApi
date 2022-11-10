package com.systemastics.api.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class Calificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer calificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	private ProductService productos_servicios;

	public Calificacion() {
		productos_servicios = new ProductService();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductService getProductServices() {
		return productos_servicios;
	}

	public void setProductServices(ProductService productos_servicios) {
		this.productos_servicios = productos_servicios;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}