package com.systemastics.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String calle;
	private String numero_int;
	private String numero_ext;
	private String alcaldia;
	private String estado;
	private String ciudad;
	private String pais;

	@ManyToOne(fetch = FetchType.LAZY)
	private ProductService productos_servicios;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarios;
	
	public Direccion() {
		productos_servicios = new ProductService();
		usuarios = new Usuario();
	}
	
	
	public ProductService getProductos_servicios() {
		return productos_servicios;
	}


	public void setProductos_servicios(ProductService productos_servicios) {
		this.productos_servicios = productos_servicios;
	}


	public Usuario getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero_int() {
		return numero_int;
	}

	public void setNumero_int(String numero_int) {
		this.numero_int = numero_int;
	}

	public String getNumero_ext() {
		return numero_ext;
	}

	public void setNumero_ext(String numero_ext) {
		this.numero_ext = numero_ext;
	}

	public String getAlcaldia() {
		return alcaldia;
	}

	public void setAlcaldia(String alcaldia) {
		this.alcaldia = alcaldia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ProductService getProductService() {
		return productos_servicios;
	}

	public void setProductService(ProductService productos_servicios) {
		productos_servicios = productos_servicios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}